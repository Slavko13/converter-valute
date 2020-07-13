package ru.converter.valuteconverterapi;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.converter.oauthdb.services.ValuteService;
import ru.converter.valuteapiclient.services.ValuteApiService;

@RestController
public class Controller {

    private final ValuteService valuteService;
    private final ValuteApiService valuteApiService;


    public Controller(ValuteService valuteService, ValuteApiService valuteApiService) {
        this.valuteService = valuteService;
        this.valuteApiService = valuteApiService;
    }


    @GetMapping("/test")
    public void test() {
        valuteApiService.getValuteById((long) 1);
    }

}
