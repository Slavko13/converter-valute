package ru.converter.emailclient.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class EmailServiceQueueConfig {


    @Bean
    public Queue getEmailFromRegistrationService() {
        return new Queue("get.email.from.registration.service");
    }


}
