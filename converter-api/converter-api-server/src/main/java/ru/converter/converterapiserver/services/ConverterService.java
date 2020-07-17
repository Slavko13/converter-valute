package ru.converter.converterapiserver.services;

import ru.converter.converterapiclient.dto.ValuteFromConverterDTO;
import ru.converter.valuteapiclient.dto.ValuteDTO;

public interface ConverterService {


    void getValutesFromValuteApi(ValuteDTO valuteDTO);
    double convertValutes(ValuteFromConverterDTO valuteMap);

}
