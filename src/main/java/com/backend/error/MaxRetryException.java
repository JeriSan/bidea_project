package com.backend.error;

public class MaxRetryException extends RuntimeException {

    public MaxRetryException(String message) {
        super(message);
    }
}
