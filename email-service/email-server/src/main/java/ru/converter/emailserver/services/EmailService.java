package ru.converter.emailserver.services;

import ru.converter.emailclient.dto.EmailDTO;

import javax.mail.MessagingException;

public interface EmailService {

    void send(EmailDTO emailDTO) throws MessagingException;


}
