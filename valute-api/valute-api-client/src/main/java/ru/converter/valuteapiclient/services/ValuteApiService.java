package ru.converter.valuteapiclient.services;


import ru.converter.valuteapiclient.dto.ValuteDTO;

public interface ValuteApiService {

    void getValuteById(ValuteDTO valuteDTO);
    void getValutesToConvert(ValuteDTO valuteDTO);
}
