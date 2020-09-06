package ru.converter.oauthdb.services;

import ru.converter.oauthdb.domains.ConfirmCode;
import ru.converter.oauthdb.domains.user.User;

import java.util.UUID;

public interface ConfirmCodeService {

    ConfirmCode prepareAndSave(User user, ConfirmCode.Action action);
    ConfirmCode findByCode(UUID code);
    void deleteByCode(UUID code);



}
