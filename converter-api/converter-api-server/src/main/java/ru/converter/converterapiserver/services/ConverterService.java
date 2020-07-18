package ru.converter.converterapiserver.services;

import ru.converter.converterapiclient.dto.ValuteFromConverterDTO;
import ru.converter.oauthdb.dto.ResultDTO;
import ru.converter.valuteapiclient.dto.ValuteDTO;

public interface ConverterService {


    void getValutesFromValuteApi(ValuteDTO valuteDTO);
    ResultDTO convertValutes(ValuteDTO valuteDTO);

}
