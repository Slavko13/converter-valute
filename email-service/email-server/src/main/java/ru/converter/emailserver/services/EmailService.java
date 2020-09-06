package ru.converter.emailserver.services;

import ru.converter.emailclient.dto.EmailDTO;

public interface EmailService {

    void send(EmailDTO emailDTO);


}
