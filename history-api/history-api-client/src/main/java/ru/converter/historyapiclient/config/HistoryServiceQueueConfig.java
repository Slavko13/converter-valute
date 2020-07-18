package ru.converter.historyapiclient.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class HistoryServiceQueueConfig {

    @Bean
    public Queue getResultFromConverter() {
        return new Queue("get.result.from.converter.to.save.history");
    }


}
