package ru.converter.oauthdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.converter.base.exceptions.NotFoundException;
import ru.converter.oauthdb.domains.user.User;
import ru.converter.oauthdb.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    @Transactional
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    @Transactional
    public User findByEmail(String email) {
        return userRepo.findByEmail(email).orElseThrow(() -> new NotFoundException("{UserServiceImpl.findByEmail.NotFound}"));
    }

    @Override
    @Transactional
    public boolean existsByEmail(String email) {
        return userRepo.existsByEmail(email);
    }
}
