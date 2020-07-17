package ru.converter.converterapiclient.services;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.converter.converterapiclient.dto.ValuteFromConverterDTO;
import ru.converter.oauthdb.domains.Valute;

import java.util.Map;

@Service
public class ConverterClientServiceImpl implements ConverterClientService {

    private final AmqpTemplate amqpTemplate;

    @Value("#{getValutesFromValuteApi.name}")
    private String GET_INFO_FROM_VALUTE_API;

    public ConverterClientServiceImpl(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @Override
    public void getValutesFromValutesApi(ValuteFromConverterDTO valuteMap) {
           amqpTemplate.convertAndSend(GET_INFO_FROM_VALUTE_API ,valuteMap);
    }
}
