package ru.converter.accountservice.service;


import ru.converter.accountservice.dto.ConfirmDTO;
import ru.converter.accountservice.dto.RegistrationDTO;

public interface RegistrationService {

    void registration(RegistrationDTO registrationDTO);
    void confirm(String confirmCode, String login);

}
