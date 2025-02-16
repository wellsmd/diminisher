package com.bloomtech.exceptions;

public class InvalidURLException extends RuntimeException {
    public InvalidURLException(String message) {
        super(message);
    }
}
