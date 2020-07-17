package ru.converter.converterapiserver.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.converter.converterapiserver.services.ConverterService;
import ru.converter.valuteapiclient.dto.ValuteDTO;

@RestController
public class MainConvertController {

    private final ConverterService converterService;

    public MainConvertController(ConverterService converterService) {
        this.converterService = converterService;
    }


    @GetMapping("/test")
    public void getTest() {
        ValuteDTO valuteDTO = new ValuteDTO();
        valuteDTO.setValuteFromID(1);
        valuteDTO.setValuteToID(2);
        valuteDTO.setFromValuteValue((double) 3);
        converterService.getValutesFromValuteApi(valuteDTO);
    }



}
