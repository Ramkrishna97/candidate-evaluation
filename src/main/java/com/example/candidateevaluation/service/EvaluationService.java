package com.example.candidateevaluation.service;

import com.example.candidateevaluation.model.Candidate;
import com.example.candidateevaluation.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluationService {
    @Autowired
    private CandidateRepository repo;

    public void saveEvaluatorsForCandidate(){
        // Implementation to save evaluators for a candidate
        Candidate candidate=new Candidate();

    }
    public void assignScores(){
        // Implementation to assign scores to candidates
    }

}
