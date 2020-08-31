package ru.converter.base.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Map;
import java.util.Set;

public class InternalServerException extends RequestException{

    private static final HttpStatus HTTP_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;
    private static final String NOTICE_MESSAGE_I18N_CODE = "{InternalServerException.message}";

    public InternalServerException() {
        super(NOTICE_MESSAGE_I18N_CODE,  null, HTTP_STATUS, null);
    }

    public InternalServerException(String message) {
        super(message, null, HTTP_STATUS, null);
    }

    public InternalServerException(String message, Map<String, Set<String>> content) {
        super(message, null, HTTP_STATUS,  content);
    }

    public InternalServerException(String message, Throwable cause) {
        super(message, cause, HTTP_STATUS, null);
    }

    public InternalServerException(String message, Map<String, Set<String>> content, Throwable cause) {
        super(message, cause, HTTP_STATUS, content);
    }

    public InternalServerException(Throwable cause) {
        super(NOTICE_MESSAGE_I18N_CODE, cause, HTTP_STATUS, null);
    }

}
