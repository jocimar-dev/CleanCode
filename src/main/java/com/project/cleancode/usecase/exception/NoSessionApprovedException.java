package com.project.cleancode.usecase.exception;

public class NoSessionApprovedException extends RuntimeException {
    public NoSessionApprovedException(String message) {
        super(message);
    }
}
