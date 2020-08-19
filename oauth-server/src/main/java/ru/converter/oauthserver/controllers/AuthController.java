package ru.converter.oauthserver.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.converter.oauthdbtools.domains.UserOauth.User;


@Controller
@RequestMapping("/auth")
public class AuthController {


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


        return "redirect:/auth/login";
    }




}
