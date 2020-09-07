package ru.converter.accountservice.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.converter.accountservice.dto.RegistrationDTO;
import ru.converter.accountservice.service.RegistrationService;
import ru.converter.oauthdb.repositories.RoleRepo;


@Controller
public class RegistrationController {

    private final RegistrationService registrationService;



    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
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

    @GetMapping("registration/confirm/{confirmCode}/{login}")
    public ResponseEntity confirmEmail(@PathVariable String confirmCode, @PathVariable String login) {
        registrationService.confirm(confirmCode, login);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
