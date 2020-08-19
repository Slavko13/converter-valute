package ru.converter.oauthdbtools.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.converter.oauthdbtools.domains.UserOauth.User;
import ru.converter.oauthdbtools.repositories.UserRepo;

public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User deleteUser(User user) {
        return null;
    }
}
