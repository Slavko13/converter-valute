package ru.converter.valuteapiserver.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.converter.oauthdb.services.ValuteService;
import ru.converter.rabbitmq.config.AbstractRabbitConfig;
import ru.converter.valuteapiclient.config.ValuteServiceQueueConfig;
import ru.converter.valuteapiserver.services.ValuteInfoService;


@Configuration
@Import({ValuteServiceQueueConfig.class})
public class RabbitConfig extends AbstractRabbitConfig {
}
