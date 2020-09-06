package ru.converter.oauthdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.converter.base.exceptions.NotFoundException;
import ru.converter.oauthdb.domains.ConfirmCode;
import ru.converter.oauthdb.domains.user.User;
import ru.converter.oauthdb.repositories.ConfirmCodeRepo;

import java.util.UUID;


@Service
public class ConfirmCodeServiceImpl implements ConfirmCodeService {

    private final ConfirmCodeRepo confirmCodeRepo;


    @Autowired
    public ConfirmCodeServiceImpl(ConfirmCodeRepo confirmCodeRepo) {
        this.confirmCodeRepo = confirmCodeRepo;
    }

    @Override
    @Transactional
    public ConfirmCode prepareAndSave(User user, ConfirmCode.Action action) {

        ConfirmCode confirmCode =  ConfirmCode.builder()
                .action(action)
                .confirmCode(UUID.randomUUID())
                .user(user)
                .build();

        return confirmCodeRepo.save(confirmCode);
    }

    @Override
    @Transactional
    public ConfirmCode findByCode(UUID code) {
        return confirmCodeRepo.findById(code).orElseThrow(() -> new NotFoundException("{ConfirmCodeServiceImpl.findByCode.NotFound}"));
    }

    @Override
    @Transactional
    public void  deleteByCode(UUID code) {
         confirmCodeRepo.deleteById(code);
    }
}
