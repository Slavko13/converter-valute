package ru.converter.oauthdb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import ru.converter.oauthdb.domains.Valute;


public interface ValuteRepo extends CrudRepository<Valute, Integer> {
}
