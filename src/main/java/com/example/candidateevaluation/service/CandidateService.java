package com.example.candidateevaluation.service;

import com.example.candidateevaluation.model.Candidate;
import com.example.candidateevaluation.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository repo;

    public void saveCandidate(Candidate candidate){
        repo.save(candidate);
    }
    public List<Candidate> findAllCandidate(){
        return repo.findAll();
    }
    public Candidate findCandidateById(Long id){
        return repo.findById(id).orElse(null);
    }
}
