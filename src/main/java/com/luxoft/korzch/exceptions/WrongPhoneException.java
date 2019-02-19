package com.luxoft.korzch.exceptions;

public class WrongPhoneException extends RuntimeException {

    public WrongPhoneException(String message) {
        super(message);
    }

    public WrongPhoneException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongPhoneException(Throwable cause) {
        super(cause);
    }

    public WrongPhoneException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public WrongPhoneException() {
    }
}
