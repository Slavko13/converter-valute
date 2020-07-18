package ru.converter.converterapiserver.services;

import org.springframework.stereotype.Service;
import ru.converter.historyapiclient.services.HistoryClientService;
import ru.converter.oauthdb.domains.Valute;
import ru.converter.oauthdb.dto.ResultDTO;
import ru.converter.oauthdb.repositories.ValuteRepo;
import ru.converter.valuteapiclient.dto.ValuteDTO;
import ru.converter.valuteapiclient.services.ValuteApiService;

import java.text.DecimalFormat;
import java.time.LocalDate;

@Service
public class ConverterServiceImpl implements ConverterService {

    private final ValuteApiService valuteApiService;
    private final ValuteRepo valuteRepo;
    private final HistoryClientService historyClientService;

    public ConverterServiceImpl(ValuteApiService valuteApiService, ValuteRepo valuteRepo, HistoryClientService historyClientService) {
        this.valuteApiService = valuteApiService;
        this.valuteRepo = valuteRepo;
        this.historyClientService = historyClientService;
    }

    @Override
    public void getValutesFromValuteApi(ValuteDTO valuteDTO) {
        valuteApiService.getValutesToConvert(valuteDTO);
    }

    @Override
    public ResultDTO convertValutes(ValuteDTO valuteDTO) {

        String pattern = "##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        Valute sourceValute =  valuteRepo.findById(valuteDTO.getValuteFromID()).orElse(null);
        Valute targetValute = valuteRepo.findById(valuteDTO.getValuteToID()).orElse(null);
        double result =  Double.parseDouble(decimalFormat.format(sourceValute.getValue()*valuteDTO.getFromValuteValue()/targetValute.getValue()).replace(",", "."));
        ResultDTO resultDTO = new ResultDTO(sourceValute.getName(), targetValute.getName(), valuteDTO.getFromValuteValue(), result, LocalDate.now());
        historyClientService.sendToSaveHistory(resultDTO);
        return resultDTO;
    }

}
