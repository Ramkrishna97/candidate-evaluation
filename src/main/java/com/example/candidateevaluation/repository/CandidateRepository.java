package com.example.candidateevaluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.candidateevaluation.model.Candidate;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    List<Candidate> findByEvaluationStatus(Candidate.EvaluationStatus status);
    List<Candidate> findBySkillSetContainingIgnoreCase(String skill);
    List<Candidate> findByLocation(String location);

    @Query("SELECT c FROM Candidate c WHERE " +
            "LOWER(c.name) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
            "LOWER(c.email) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
            "LOWER(c.skillSet) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Candidate> searchCandidates(String query);
}