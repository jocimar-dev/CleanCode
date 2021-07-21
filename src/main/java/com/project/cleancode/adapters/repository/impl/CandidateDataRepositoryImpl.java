package com.project.cleancode.adapters.repository.impl;

import com.project.cleancode.adapters.data.CandidateData;
import com.project.cleancode.domain.model.Candidate;

public class CandidateDataRepositoryImpl{

    public Candidate saveCandidate(CandidateData candidateData) {
        return new Candidate(saveCandidate(candidateData));
    }
}
