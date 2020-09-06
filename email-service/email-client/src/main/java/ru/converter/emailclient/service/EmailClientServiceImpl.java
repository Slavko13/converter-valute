package ru.converter.emailclient.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.converter.emailclient.dto.EmailDTO;


@Service
public class EmailClientServiceImpl implements EmailClientService {

    @Value("#{getEmailFromRegistrationService.name}")
    private String SEND_EMAIL;

    private final AmqpTemplate amqpTemplate;

    public EmailClientServiceImpl(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }


    @Override
    public void send(EmailDTO emailDTO) {
        amqpTemplate.convertAndSend(SEND_EMAIL, emailDTO);
    }
}
