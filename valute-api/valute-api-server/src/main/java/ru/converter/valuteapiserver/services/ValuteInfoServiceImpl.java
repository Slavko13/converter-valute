package ru.converter.valuteapiserver.services;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;
import ru.converter.oauthdb.domains.Valute;
import ru.converter.oauthdb.services.ValuteService;

import java.util.List;


@Service
public class ValuteInfoServiceImpl implements ValuteInfoService {

    private final ValuteService valuteService;


    private final AmqpTemplate amqpTemplate;


    public ValuteInfoServiceImpl(ValuteService valuteService, AmqpTemplate amqpTemplate) {
        this.valuteService = valuteService;
        this.amqpTemplate = amqpTemplate;
    }


    @Override
    public List<Valute> getValutes() {
        return valuteService.getAllValutes();
    }

    @Override
    public void getValuteById(Long id) {
        System.out.println(valuteService.getValuteById(id).getName());
    }
}
