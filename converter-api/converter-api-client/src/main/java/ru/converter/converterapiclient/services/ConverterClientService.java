package ru.converter.converterapiclient.services;

import ru.converter.converterapiclient.dto.ValuteFromConverterDTO;
import ru.converter.oauthdb.domains.Valute;

import java.util.Map;

public interface ConverterClientService {

    void getValutesFromValutesApi(ValuteFromConverterDTO valuteMap);


}
