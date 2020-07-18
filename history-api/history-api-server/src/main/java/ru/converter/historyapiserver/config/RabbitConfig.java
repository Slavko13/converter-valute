package ru.converter.historyapiserver.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.converter.historyapiclient.config.HistoryServiceQueueConfig;
import ru.converter.rabbitmq.config.AbstractRabbitConfig;

@Configuration
@Import({HistoryServiceQueueConfig.class})
public class RabbitConfig extends AbstractRabbitConfig {
}
