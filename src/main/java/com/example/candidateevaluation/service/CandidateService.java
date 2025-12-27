package com.example.candidateevaluation.service;

import com.example.candidateevaluation.model.Candidate;
import com.example.candidateevaluation.repository.CandidateRepository;
import jakarta.transaction.Transactional;
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
    public Candidate getCandidateById(Long id){
        return repo.findById(id).orElseThrow(()-> new RuntimeException("Candidate with id- "+id+" ,not found"));
    }
    public List<Candidate> getCandidatesByStatus(Candidate.EvaluationStatus status) {
        return repo.findByEvaluationStatus(status);
    }
    @Transactional
    public Candidate updateCandidateStatus(Long id, Candidate.EvaluationStatus status) {
        Candidate candidate = getCandidateById(id);
        candidate.setEvaluationStatus(status);
        candidate.setUpdatedAt(java.time.LocalDateTime.now());
        return repo.save(candidate);
    }
    public List<Candidate> searchCandidates(String query) {
        return repo.searchCandidates(query);
    }

    public void deleteCandidate(Long id) {
        repo.deleteById(id);
    }
    public String deleteAllCandidate(){
        long count=repo.count();
        repo.deleteAll();
        return count+" candidates deleted successfully";
    }

    public long getTotalCandidates() {
        return repo.count();
    }



}
