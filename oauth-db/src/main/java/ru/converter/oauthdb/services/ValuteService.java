package ru.converter.oauthdb.services;

import org.springframework.beans.factory.annotation.Value;
import ru.converter.oauthdb.domains.Valute;

public interface ValuteService {

    Valute getValuteById();

}
