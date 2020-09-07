package ru.converter.emailserver.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.converter.emailclient.dto.EmailDTO;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    private String username;

    private final JavaMailSender javaMailSender;


    @Autowired
    public EmailServiceImpl(@Qualifier("getJavaMailSender") JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    @Override
    public void send(EmailDTO emailDTO) {

        String content = String.format(
          "Hello, %s! Welcome to myApp. Please, visit next link to activate your account http://localhost:8084/registration/confirm/%s/%s",
                emailDTO.getContent().get("userLogin").toString(),
                emailDTO.getContent().get("confirmCode").toString(),
                emailDTO.getContent().get("userLogin").toString());


        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(username);
        message.setTo(emailDTO.getMessageTo());
        message.setText(content);
        javaMailSender.send(message);
    }
}
