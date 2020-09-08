package ru.converter.accountservice.service;


import ru.converter.accountservice.dto.ConfirmDTO;
import ru.converter.accountservice.dto.RegistrationDTO;

import java.util.UUID;

public interface RegistrationService {

    void registration(RegistrationDTO registrationDTO);
    void confirm(UUID confirmCode, String login);

}
