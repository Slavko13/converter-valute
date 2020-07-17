package ru.converter.valuteapiserver.services;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.converter.converterapiclient.dto.ValuteFromConverterDTO;
import ru.converter.converterapiclient.services.ConverterClientService;
import ru.converter.oauthdb.domains.Valute;
import ru.converter.oauthdb.repositories.ValuteRepo;
import ru.converter.valuteapiclient.dto.ValuteDTO;

import java.util.HashMap;
import java.util.Map;


@Service
public class ValuteInfoServiceImpl implements ValuteInfoService {


    private final AmqpTemplate amqpTemplate;
    private final ValuteRepo valuteRepo;
    private final ConverterClientService converterClientService;

    public ValuteInfoServiceImpl(AmqpTemplate amqpTemplate, ValuteRepo valuteRepo, ConverterClientService converterClientService) {
        this.amqpTemplate = amqpTemplate;
        this.valuteRepo = valuteRepo;
        this.converterClientService = converterClientService;
    }


    @Override
    @Transactional
    public Map<String, Valute> getValutesFromConverter(ValuteDTO valuteDTO) {
        Map<String, Valute> valuteMap = new HashMap<>();
        ValuteFromConverterDTO valuteFromConverterDTO = new ValuteFromConverterDTO();
        Valute valuteFrom = valuteRepo.findById(valuteDTO.getValuteFromID()).get();
        Valute valuteTo = valuteRepo.findById(valuteDTO.getValuteToID()).get();
        valuteMap.put("valuteFrom", valuteFrom);
        valuteMap.put("valuteTo", valuteTo);
        valuteFromConverterDTO.setValuteFromValue(valuteDTO.getFromValuteValue());
        valuteFromConverterDTO.setValuteMap(valuteMap);
        converterClientService.getValutesFromValutesApi(valuteFromConverterDTO);
        return valuteMap;
    }


}
