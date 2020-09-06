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

    private static final String HOST = "mail.host";
    private static final String PORT = "mail.port";
    private static final String USERNAME = "mail.username";
    private static final String PASSWORD = "mail.password";


    @Bean(name = "getJavaMailSender")
    public JavaMailSender getJavaMailSender(Environment environment) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(environment.getRequiredProperty(HOST));
        mailSender.setPort(environment.getRequiredProperty(PORT, Integer.TYPE));
        mailSender.setUsername(environment.getRequiredProperty(USERNAME));
        mailSender.setPassword(environment.getRequiredProperty(PASSWORD));

        return mailSender;
    }

}
