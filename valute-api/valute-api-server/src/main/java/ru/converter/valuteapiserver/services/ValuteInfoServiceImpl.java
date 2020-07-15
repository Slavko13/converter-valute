package ru.converter.valuteapiserver.services;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.converter.oauthdb.domains.Valute;
import ru.converter.oauthdb.repositories.ValuteRepo;
import ru.converter.oauthdb.services.ValuteService;

import java.util.List;


@Service
public class ValuteInfoServiceImpl implements ValuteInfoService {


    private final AmqpTemplate amqpTemplate;
    private final ValuteRepo valuteRepo;

    public ValuteInfoServiceImpl(AmqpTemplate amqpTemplate, ValuteRepo valuteRepo) {
        this.amqpTemplate = amqpTemplate;
        this.valuteRepo = valuteRepo;
    }


    @Override
    @Transactional
    public void getValuteById(Long id) {
        System.out.println(valuteRepo.findById(id).get().getName());
    }
}
