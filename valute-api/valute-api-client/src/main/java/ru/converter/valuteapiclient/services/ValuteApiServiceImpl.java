package ru.converter.valuteapiclient.services;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class ValuteApiServiceImpl implements ValuteApiService {

    @Value("#{getInfoToConverter.name}")
    private String GET_INFO_TO_CONVERTER;


    private final AmqpTemplate amqpTemplate;

    @Autowired
    public ValuteApiServiceImpl(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }


    @Override
    public void getValuteById(Long id) {
        amqpTemplate.convertAndSend(GET_INFO_TO_CONVERTER, "id" );
    }
}
