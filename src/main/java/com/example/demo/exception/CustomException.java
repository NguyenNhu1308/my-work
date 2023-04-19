package com.example.demo.exception;

public class CustomException extends RuntimeException {
    protected int code;

    public CustomException(String message) {
        super(message);
    }
}
