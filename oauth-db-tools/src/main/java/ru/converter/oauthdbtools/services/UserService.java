package ru.converter.oauthdbtools.services;


import org.springframework.stereotype.Service;
import ru.converter.oauthdbtools.domains.UserOauth.User;


@Service
public interface UserService {

    User addUser(User user);
    User updateUser(User user);
    User deleteUser(User user);


}
