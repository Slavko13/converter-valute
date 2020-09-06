package ru.converter.oauthdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.converter.oauthdb.domains.Valute;
import ru.converter.oauthdb.repositories.ValuteRepo;

import java.util.List;


@Service
public class ValuteServiceImpl implements ValuteService {



    private final ValuteRepo valuteRepo;

    @Autowired

    public ValuteServiceImpl(ValuteRepo valuteRepo) {
        this.valuteRepo = valuteRepo;
    }

    @Override
    @Transactional
    public Valute getValuteById(Integer id) {
        return valuteRepo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<Valute> getAllValutes() {
        return (List<Valute>) valuteRepo.findAll();
    }

    @Override
    @Transactional
    public Valute saveValute(Valute valute) {
        return valuteRepo.save(valute);
    }

    @Override
    @Transactional
    public Valute deleteValute(Valute valute) {
        return null;
    }


}
