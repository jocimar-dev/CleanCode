package com.project.cleancode.domain.usecase;

import com.project.cleancode.adapters.data.CandidateData;
import com.project.cleancode.domain.model.Candidate;
import org.springframework.stereotype.Service;

@Service
public interface CandidateService {
    Candidate register(CandidateData candidateData);

}
