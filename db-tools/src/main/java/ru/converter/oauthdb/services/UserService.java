package ru.converter.oauthdb.services;

import ru.converter.oauthdb.domains.user.User;

import java.util.Optional;

public interface UserService {
    void saveUser(User user);
    User findByEmail(String email);
    boolean existsByEmail(String email);
    User findByLogin(String login);
}
