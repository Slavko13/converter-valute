package ru.converter.valuteapiclient.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValuteServiceQueueConfig {

    @Bean
    public Queue getInfoToConverter() {
        return new Queue("valute.getter.from.converter.service");
    }

    @Bean
    public Queue getInfoToHistory() {
        return new Queue("valute.getter.from.history.service");
    }

}
