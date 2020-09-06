package ru.converter.emailclient.service;

import ru.converter.emailclient.dto.EmailDTO;

public interface EmailClientService {

    void send(EmailDTO emailDTO);

}
