package ru.converter.oauthdb.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.converter.oauthdb.domains.TestOfTests;

public interface TestOfTestRepo extends CrudRepository<TestOfTests, Long> {

}
