package ru.converter.accountservice.dto;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfirmDTO {

    @NotNull
    private String login;
    @NotNull
    private UUID confirmCode;


}
