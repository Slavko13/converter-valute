package ru.converter.accountservice.utils;


import org.springframework.stereotype.Component;
import ru.converter.emailclient.dto.EmailDTO;
import ru.converter.oauthdb.domains.ConfirmCode;
import ru.converter.oauthdb.domains.user.User;

import java.util.Map;


public class EmailUtil {


    public static EmailDTO createEmailToSend(ConfirmCode confirmCode) {
        return EmailDTO.builder()
                .messageTo(confirmCode.getUser().getEmail())
                .content(Map.of("userLogin", confirmCode.getUser().getLogin(),
                                "confirmCode", confirmCode.getConfirmCode()))
                .build();
    }



}
