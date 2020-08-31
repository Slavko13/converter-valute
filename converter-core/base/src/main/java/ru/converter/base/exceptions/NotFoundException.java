package ru.converter.base.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Map;
import java.util.Set;

public class NotFoundException extends RequestException {

    private static final HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;


    public NotFoundException() {
        super(null, null, HTTP_STATUS, null);
    }

    public NotFoundException(String message) {
        super(message, null, HTTP_STATUS, null);
    }

    public NotFoundException(String message, Map<String, Set<String>> content) {
        super(message, null, HTTP_STATUS, content);
    }

    public NotFoundException(String message, Map<String, Set<String>> content, Throwable cause) {
        super(message, cause, HTTP_STATUS, content);
    }

    public NotFoundException(Throwable cause) {
        super(null, cause, HTTP_STATUS, null);
    }


}
