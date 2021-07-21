package com.project.cleancode.domain.usecase.exception;

public class CandidateDoesntMeetRequirementsException extends RuntimeException {
    public CandidateDoesntMeetRequirementsException(String message) {
        super (message);
    }
}
