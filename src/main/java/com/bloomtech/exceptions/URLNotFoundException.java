package com.bloomtech.exceptions;

public class URLNotFoundException extends RuntimeException {
    public URLNotFoundException(String message) {
        super(message);
    }
}
