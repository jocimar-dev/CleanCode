package com.project.cleancode.adapters.data.controller;

import com.project.cleancode.domain.model.Candidate;
import com.project.cleancode.domain.repository.CandidateRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CandidateController {

    private CandidateRepository candidateRepository;


    public CandidateController(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @PostMapping("/candidate")
    Candidate consultaTransacao( Candidate candidate) {
        return candidateRepository.save(candidate);

    }
}
