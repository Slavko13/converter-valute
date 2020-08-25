package ru.converter.oauthserver.service;


import ru.converter.oauthdb.domains.user.User;

public interface UserService {

    User addUser(User user);
    User updateUser(User user);
    User deleteUser(User user);


}
