package ru.converter.accountservice.utils;

import ru.converter.emailclient.dto.EmailDTO;
import ru.converter.oauthdb.domains.ConfirmCode;

import java.util.Map;


public class EmailUtil {


    public static EmailDTO createEmailToSend(ConfirmCode confirmCode) {
        return EmailDTO.builder()
                .messageTo(confirmCode.getUser().getEmail())
                .template(confirmCode.getAction().name().toLowerCase())
                .subject("Подтверждение регистрации на сайте")
                .content(Map.of("userLogin", confirmCode.getUser().getLogin(),
                                "confirmCode", confirmCode.getConfirmCode()))
                .build();
    }



}
