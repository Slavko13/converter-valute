package ru.converter.base.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Map;
import java.util.Set;

public class BadRequestException extends RequestException {

    private static final HttpStatus HTTP_STATUS = HttpStatus.BAD_REQUEST;
    private static final String NOTICE_MESSAGE_I18N_CODE = "{BadRequestException.message}";


    public BadRequestException() {
        super(NOTICE_MESSAGE_I18N_CODE, null, HTTP_STATUS, null);
    }

    public BadRequestException(String message) {
        super(message, null, HTTP_STATUS, null);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, null,HTTP_STATUS, null);
    }

    public BadRequestException(Map<String, Set<String>> content) {
        super(NOTICE_MESSAGE_I18N_CODE, null, HTTP_STATUS, content);
    }

    public BadRequestException(String message, Map<String, Set<String>> content) {
        super(message, null, HTTP_STATUS, content);
    }

    public BadRequestException(String message, Map<String, Set<String>> content, Throwable cause) {
        super(message, cause, HTTP_STATUS, content);
    }

    public BadRequestException(Throwable cause) {
        super(NOTICE_MESSAGE_I18N_CODE, cause, HTTP_STATUS, null);
    }

}
