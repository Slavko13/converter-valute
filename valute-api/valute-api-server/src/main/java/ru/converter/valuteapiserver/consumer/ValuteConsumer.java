package ru.converter.valuteapiserver.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;
import ru.converter.oauthdb.domains.Valute;
import ru.converter.valuteapiclient.dto.ValuteDTO;
import ru.converter.valuteapiserver.services.ValuteInfoService;

import java.util.List;

@Component
public class ValuteConsumer {

    private final ValuteInfoService valuteInfoService;

    public ValuteConsumer(ValuteInfoService valuteInfoService) {
        this.valuteInfoService = valuteInfoService;
    }

    @RabbitListener(queues = "#{getInfoToConverter.name}")
    public void send(ValuteDTO valuteDTO) throws MessagingException {
        valuteInfoService.getValutesFromConverter(valuteDTO);
    }

}
