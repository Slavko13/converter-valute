package ru.converter.accountservice.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.converter.accountservice.dto.ConfirmDTO;
import ru.converter.accountservice.dto.RegistrationDTO;
import ru.converter.base.exceptions.BadRequestException;
import ru.converter.base.exceptions.InternalServerException;
import ru.converter.oauthdb.domains.user.Role;
import ru.converter.oauthdb.domains.user.Status;
import ru.converter.oauthdb.domains.user.User;
import ru.converter.oauthdb.services.UserService;

import java.util.Map;
import java.util.Set;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationServiceImpl(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registration(RegistrationDTO registrationDTO) {
        boolean emailBusy = userService.existsByEmail(registrationDTO.getEmail());

        if (emailBusy) {
            throw new BadRequestException(Map.of("email", Set.of("{RegistrationServiceImpl.registration.emailBusy}")));
        }

        try {
            User user = User.builder()
                    .firstName(registrationDTO.getFirstName())
                    .lastName(registrationDTO.getSecondName())
                    .login(registrationDTO.getLogin())
                    .email(registrationDTO.getEmail())
                    .password(passwordEncoder.encode(registrationDTO.getPassword()))
                    .status(Status.NOT_ACTIVE)
                    .role(new Role("ROLE_GUEST"))
                    .build();
            userService.saveUser(user);

            // TODO: email confirmationCode

        }
        catch (Exception ex) {
            throw new InternalServerException("{RegistrationServiceImpl.registration.internalServerException}", ex);
        }

    }



    @Override
    public void confirm(String confirmCode, String login) {

    }
}
