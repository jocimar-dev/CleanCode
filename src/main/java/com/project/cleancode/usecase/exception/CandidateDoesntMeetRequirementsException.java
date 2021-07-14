package com.project.cleancode.usecase.exception;

public class CandidateDoesntMeetRequirementsException extends RuntimeException {
    public CandidateDoesntMeetRequirementsException(String message) {
        super (message);
    }
}
