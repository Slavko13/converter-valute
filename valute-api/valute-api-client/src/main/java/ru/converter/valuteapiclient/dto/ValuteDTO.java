package ru.converter.valuteapiclient.dto;


import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class ValuteDTO implements Serializable {

    private Integer valuteFromID;
    private Integer valuteToID;
    private Double fromValuteValue;

}
