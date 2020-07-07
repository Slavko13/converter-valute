package ru.converter.oauthdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import ru.converter.oauthdb.domains.Valute;
import ru.converter.oauthdb.repositories.ValuteRepo;


@Service
public class ValuteServiceImpl implements ValuteService {



    private final ValuteRepo valuteRepo;

    @Autowired
    public ValuteServiceImpl(ValuteRepo valuteRepo) {
        this.valuteRepo = valuteRepo;
    }


    @Override
    public Valute getValuteById() {
        Valute valute = valuteRepo.findById((long) 1).orElse(null);
        System.out.println(valute.getId());
        return valute;
    }

}
