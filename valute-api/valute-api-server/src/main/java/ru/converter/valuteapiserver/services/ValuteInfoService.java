package ru.converter.valuteapiserver.services;

import ru.converter.oauthdb.domains.Valute;
import ru.converter.valuteapiclient.dto.ValuteDTO;

import java.util.Map;

public interface ValuteInfoService  {



    Map<String, Valute> getValutesFromConverter(ValuteDTO valuteDTO);



}
