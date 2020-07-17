package ru.converter.oauthdb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.converter.oauthdb.domains.History;

@Repository
public interface HistoryRepo extends CrudRepository<History, Integer> {


}
