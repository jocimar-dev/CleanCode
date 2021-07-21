package com.project.cleancode.domain.usecase.exception;

public class NoSessionApprovedException extends RuntimeException {
    public NoSessionApprovedException(String message) {
        super(message);
    }
}
