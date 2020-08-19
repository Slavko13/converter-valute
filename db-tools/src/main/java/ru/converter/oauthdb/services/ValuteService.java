package ru.converter.oauthdb.services;

import org.springframework.beans.factory.annotation.Value;
import ru.converter.oauthdb.domains.Valute;

import java.util.List;

public interface ValuteService {

    Valute getValuteById(Integer id);
    List<Valute> getAllValutes();
    Valute saveValute(Valute valute);
    Valute deleteValute(Valute valute);

}
