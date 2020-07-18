package ru.converter.oauthdb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.converter.oauthdb.domains.History;
import ru.converter.oauthdb.domains.Valute;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO implements Serializable {


    private String valuteNameFrom;
    private String valuteNameTo;
    private Double valuteFromValue;
    private Double result;
    private LocalDate localDate;


}
