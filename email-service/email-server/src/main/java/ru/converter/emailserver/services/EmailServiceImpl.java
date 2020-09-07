package ru.converter.emailserver.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.exceptions.TemplateProcessingException;
import ru.converter.base.exceptions.BadRequestException;
import ru.converter.emailclient.dto.EmailDTO;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    private String username;

    private final JavaMailSender javaMailSender;
    private final ITemplateEngine emailTemplateEngine;

    @Autowired
    public EmailServiceImpl(@Qualifier("getJavaMailSender") JavaMailSender javaMailSender, ITemplateEngine emailTemplateEngine) {
        this.javaMailSender = javaMailSender;
        this.emailTemplateEngine = emailTemplateEngine;
    }


    @Override
    public void send(EmailDTO emailDTO) throws MessagingException {

//        String content = String.format(
//          "Hello, %s! Welcome to myApp. Please, visit next link to activate your account http://localhost:8084/registration/confirm/%s/%s",
//                emailDTO.getContent().get("userLogin").toString(),
//                emailDTO.getContent().get("confirmCode").toString(),
//                emailDTO.getContent().get("userLogin").toString());

        try {
            final Context ctx = new Context();
            if(emailDTO.getContent() !=  null && !emailDTO.getContent().isEmpty()) {
                emailDTO.getContent().forEach(ctx::setVariable);
            }

            String htmlContent = this.emailTemplateEngine.process(emailDTO.getTemplate(), ctx);

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            mimeMessage.setContent(htmlContent, "text/html; charset=UTF-8");
            mimeMessage.setFrom(new InternetAddress(username));
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailDTO.getMessageTo()));
            mimeMessage.setSubject(emailDTO.getSubject(), "UTF-8");

            javaMailSender.send(mimeMessage);
        }
        catch (TemplateProcessingException | AddressException ex) {
            throw new BadRequestException(ex);
        }
    }





//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(username);
//        message.setTo(emailDTO.getMessageTo());
//        message.setText(content);
//        javaMailSender.send(message);
    }
