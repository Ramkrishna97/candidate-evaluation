package com.example.candidateevaluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.candidateevaluation.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
