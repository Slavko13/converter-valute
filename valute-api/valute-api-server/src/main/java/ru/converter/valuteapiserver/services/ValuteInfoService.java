package ru.converter.valuteapiserver.services;

import ru.converter.oauthdb.domains.Valute;

import java.util.List;

public interface ValuteInfoService  {

    List <Valute> getValutes();
    void getValuteById(Long id);




}
