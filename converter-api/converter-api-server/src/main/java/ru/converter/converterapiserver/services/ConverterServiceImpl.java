package ru.converter.converterapiserver.services;

import org.springframework.stereotype.Service;
import ru.converter.converterapiclient.dto.ValuteFromConverterDTO;
import ru.converter.oauthdb.domains.Valute;
import ru.converter.valuteapiclient.dto.ValuteDTO;
import ru.converter.valuteapiclient.services.ValuteApiService;

import java.text.DecimalFormat;

@Service
public class ConverterServiceImpl implements ConverterService {

    private final ValuteApiService valuteApiService;

    public ConverterServiceImpl(ValuteApiService valuteApiService) {
        this.valuteApiService = valuteApiService;
    }

    @Override
    public void getValutesFromValuteApi(ValuteDTO valuteDTO) {
        valuteApiService.getValutesToConvert(valuteDTO);
    }

    @Override
    public double convertValutes(ValuteFromConverterDTO valuteMap) {

        String pattern = "##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        Valute sourceValute = valuteMap.getValuteMap().get("valuteFrom");
        Valute targetValute = valuteMap.getValuteMap().get("valuteTo");
        System.out.println(Double.parseDouble(decimalFormat.format(sourceValute.getValue()*valuteMap.getValuteFromValue()/targetValute.getValue()).replace(",", ".")));
        return Double.parseDouble(decimalFormat.format(sourceValute.getValue()*valuteMap.getValuteFromValue()/targetValute.getValue()).replace(",", "."));


    }



}
