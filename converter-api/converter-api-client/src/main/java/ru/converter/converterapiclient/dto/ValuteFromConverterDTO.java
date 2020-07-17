package ru.converter.converterapiclient.dto;

import lombok.Data;
import ru.converter.oauthdb.domains.Valute;

import java.io.Serializable;
import java.util.Map;


@Data
public class ValuteFromConverterDTO implements Serializable {

    private Map<String, Valute> valuteMap;
    private Double valuteFromValue;

}
