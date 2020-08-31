package ru.converter.oauthdb.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.converter.oauthdb.domains.user.User;


import java.util.Optional;


public interface UserRepo extends CrudRepository<User, Integer> {

    Optional<User> findByLogin(String login);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

}
