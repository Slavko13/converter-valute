package ru.converter.accountservice.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.converter.accountservice.dto.RegistrationDTO;
import ru.converter.accountservice.service.RegistrationService;
import ru.converter.oauthdb.domains.user.AuthoritiesEnum;
import ru.converter.oauthdb.domains.user.Role;
import ru.converter.oauthdb.repositories.RoleRepo;

import java.util.Set;

@Controller
public class RegistrationController {

    private final RegistrationService registrationService;
    private final RoleRepo roleRepo;


    @Autowired
    public RegistrationController(RegistrationService registrationService, RoleRepo roleRepo) {
        this.registrationService = registrationService;
        this.roleRepo = roleRepo;
    }

    @GetMapping("/registration")
    public String showForm() {
        return "registrationPage";
    }

    @PostMapping("/registration")
    public String registrateUser(@ModelAttribute RegistrationDTO registrationDTO) {
        registrationService.registration(registrationDTO);
        return "redirect:/registration/lol";
    }

    @GetMapping("/confirm?confirmCode={confirmCode}&userUniqueField={login}")
    public ResponseEntity confirmEmail(@PathVariable String confirmCode, @PathVariable String login) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
