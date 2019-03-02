package com.luxoft.korzch.exceptions;

public class NotAllowedAgeException extends RuntimeException {

    public NotAllowedAgeException(String message) {
        super(message);
    }

    public NotAllowedAgeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotAllowedAgeException(Throwable cause) {
        super(cause);
    }

    public NotAllowedAgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public NotAllowedAgeException() {
    }
}
