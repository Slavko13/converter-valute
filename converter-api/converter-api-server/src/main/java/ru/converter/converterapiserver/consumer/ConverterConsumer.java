package ru.converter.converterapiserver.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;
import ru.converter.converterapiclient.dto.ValuteFromConverterDTO;
import ru.converter.converterapiserver.services.ConverterService;
import ru.converter.oauthdb.domains.Valute;

import java.util.Map;

@Component
public class ConverterConsumer {

    private final ConverterService converterService;

    public ConverterConsumer(ConverterService converterService) {
        this.converterService = converterService;
    }

    @RabbitListener(queues = "#{getValutesFromValuteApi.name}")
    public void send(ValuteFromConverterDTO valuteMap) throws MessagingException {
        converterService.convertValutes(valuteMap);
    }



}
