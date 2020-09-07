package ru.converter.emailserver.config;


import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import ru.converter.base.config.BaseConfig;

import java.util.Properties;

@SpringBootConfiguration
@Import({RabbitMqConfig.class, BaseConfig.class})
public class AppConfig {

    private static final String HOST = "spring.mail.host";
    private static final String PORT = "spring.mail.port";
    private static final String USERNAME = "spring.mail.username";
    private static final String PASSWORD = "spring.mail.password";
    private static final String PROTOCOL = "spring.mail.protocol";
    private static final String DEBUG = "mail.debug";


    @Bean(name = "getJavaMailSender")
    public JavaMailSender getJavaMailSender(Environment environment) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(environment.getRequiredProperty(HOST));
        mailSender.setPort(environment.getRequiredProperty(PORT, Integer.TYPE));
        mailSender.setUsername(environment.getRequiredProperty(USERNAME));
        mailSender.setPassword(environment.getRequiredProperty(PASSWORD));
        //mailSender.setProtocol(environment.getProperty(PROTOCOL));

        Properties properties = mailSender.getJavaMailProperties();

        //properties.setProperty("mail.transport.protocol", environment.getRequiredProperty(PROTOCOL));
        properties.setProperty("mail.debug", environment.getRequiredProperty(DEBUG));
        properties.setProperty("mail.smtp.ssl.trust", "smtp.mail.ru");
        properties.setProperty("mail.smtp.ssl.enable", "true");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        return mailSender;
    }

}
