package com.project.cleancode.adapters.repository;

import com.project.cleancode.adapters.data.CandidateData;
import com.project.cleancode.domain.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateDataRepository extends JpaRepository<Candidate, Long> {

    Candidate saveCandidate(CandidateData candidateData);


}
