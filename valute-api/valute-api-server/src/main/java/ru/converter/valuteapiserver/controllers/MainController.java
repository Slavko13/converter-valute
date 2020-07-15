package ru.converter.valuteapiserver.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;
import ru.converter.valuteapiserver.services.ValuteDownloaderService;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@RestController
public class MainController {

    private final ValuteDownloaderService valuteDownloaderService;

    public MainController(ValuteDownloaderService valuteDownloaderService) {
        this.valuteDownloaderService = valuteDownloaderService;
    }


    @GetMapping("/downLoad")
    public void downloadValutes() throws IOException, SAXException, ParserConfigurationException {
        valuteDownloaderService.downLoadValuteCourse();
    }


}
