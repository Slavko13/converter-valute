package ru.converter.converterapiclient.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConverterServiceQueueConfig {


    @Bean
    public Queue getValutesFromValuteApi() {
        return new Queue("get.valute.from.valute.api");
    }


}
