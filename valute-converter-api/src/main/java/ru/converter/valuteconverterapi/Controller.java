package ru.converter.valuteconverterapi;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.converter.oauthdb.services.ValuteService;

@RestController
public class Controller {

    private final ValuteService valuteService;

    public Controller(ValuteService valuteService) {
        this.valuteService = valuteService;
    }


    @GetMapping("/test")
    public void test() {
        valuteService.getValuteById();
    }

}
