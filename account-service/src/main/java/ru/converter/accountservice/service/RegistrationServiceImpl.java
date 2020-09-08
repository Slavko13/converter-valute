package ru.converter.accountservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.converter.accountservice.dto.RegistrationDTO;
import ru.converter.accountservice.utils.EmailUtil;
import ru.converter.base.exceptions.BadRequestException;
import ru.converter.base.exceptions.InternalServerException;
import ru.converter.emailclient.dto.EmailDTO;
import ru.converter.emailclient.service.EmailClientService;
import ru.converter.oauthdb.domains.ConfirmCode;
import ru.converter.oauthdb.domains.user.Role;
import ru.converter.oauthdb.domains.user.Status;
import ru.converter.oauthdb.domains.user.User;
import ru.converter.oauthdb.repositories.UserRepo;
import ru.converter.oauthdb.services.ConfirmCodeService;
import ru.converter.oauthdb.services.UserService;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Service
@Slf4j
public class RegistrationServiceImpl implements RegistrationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final EmailClientService emailClientService;
    private final ConfirmCodeService confirmCodeService;


    public RegistrationServiceImpl(UserService userService, PasswordEncoder passwordEncoder, UserRepo userRepo, EmailClientService emailClientService, ConfirmCodeService confirmCodeService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.emailClientService = emailClientService;
        this.confirmCodeService = confirmCodeService;
    }

    @Override
    public void registration(RegistrationDTO registrationDTO) {
        boolean emailBusy = userService.existsByEmail(registrationDTO.getEmail());

        if (emailBusy) {
            throw new BadRequestException(Map.of("email", Set.of("{RegistrationServiceImpl.registration.emailBusy}")));
        }

        try {
            User user = User.builder()
                    .id(UUID.randomUUID())
                    .firstName(registrationDTO.getFirstName())
                    .lastName(registrationDTO.getSecondName())
                    .login(registrationDTO.getLogin())
                    .email(registrationDTO.getEmail())
                    .password(passwordEncoder.encode(registrationDTO.getPassword()))
                    .status(Status.NOT_ACTIVE)
                    .role(new Role("ROLE_GUEST"))
                    .build();
            userService.saveUser(user);

            ConfirmCode confirmCode  = confirmCodeService.prepareAndSave(user, ConfirmCode.Action.REGISTRATION);
            EmailDTO  emailDTO = EmailUtil.createEmailToSend(confirmCode);
            emailClientService.send(emailDTO);
        }
        catch (Exception ex) {
            throw new InternalServerException("{RegistrationServiceImpl.registration.internalServerException}", ex);
        }

    }

    @Override
    public void confirm(UUID confirmCode, String login) {

        try {
            User user =  userService.findByLogin(login);
            user.setStatus(Status.ACTIVE);
            userService.saveUser(user);
        }
        catch (Exception ex) {
            throw new InternalServerException("{RegistrationServiceImpl.confirm.failedConfirm}", ex);
        }
        try {
            confirmCodeService.deleteByCode(confirmCode);
        }
        catch (Exception ex) {
            log.error("Failed remove confirmCode: ", ex);
        }
    }
}
