package ru.converter.oauthdb.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.converter.oauthdb.domains.user.User;


import java.util.Optional;
import java.util.UUID;


public interface UserRepo extends CrudRepository<User, UUID> {

    Optional<User> findByLogin(String login);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

}
