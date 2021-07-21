package com.project.cleancode.domain.repository;


import com.project.cleancode.adapters.data.CandidateData;
import com.project.cleancode.adapters.repository.CandidateDataRepository;
import com.project.cleancode.domain.model.Candidate;

public interface CandidateRepository extends CandidateDataRepository {
    Candidate saveCandidate(CandidateData candidate);

}
