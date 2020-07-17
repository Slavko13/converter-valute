package ru.converter.converterapiserver.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.converter.converterapiclient.config.ConverterServiceQueueConfig;
import ru.converter.rabbitmq.config.AbstractRabbitConfig;

@Configuration
@Import({ConverterServiceQueueConfig.class})
public class RabbitConfig extends AbstractRabbitConfig {


}
