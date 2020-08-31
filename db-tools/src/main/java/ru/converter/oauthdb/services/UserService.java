package ru.converter.oauthdb.services;

import ru.converter.oauthdb.domains.user.User;

public interface UserService {
    void saveUser(User user);
    User findByEmail(String email);
    boolean existsByEmail(String email);
}
