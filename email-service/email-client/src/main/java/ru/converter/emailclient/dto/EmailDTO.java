package ru.converter.emailclient.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailDTO implements Serializable {

    private String messageTo;
    private Map<String, Object> content;
    private String subject;
}
