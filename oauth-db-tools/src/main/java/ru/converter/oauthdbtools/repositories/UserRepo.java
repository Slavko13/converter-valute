package ru.converter.oauthdbtools.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.converter.oauthdbtools.domains.UserOauth.User;

public interface UserRepo extends CrudRepository<User, Integer> {



}
