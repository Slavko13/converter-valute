package ru.converter.oauthserver.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.converter.oauthdb.domains.user.Status;
import ru.converter.oauthdb.domains.user.User;
import ru.converter.oauthdb.repositories.UserRepo;


@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/login")
    public String getLoginPage() {
        return "loginPage.html";
    }


    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registrationPage.html";
    }

    @GetMapping("/main")
    public String getSuccessPage() {
        return "mainPage.html";
    }

    @PostMapping("/registration")
    public String registrateUser(@ModelAttribute User user) {
        user.setStatus(Status.ACTIVE);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return "redirect:/auth/login";
    }




}
