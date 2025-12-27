package com.example.candidateevaluation.repository;

import com.example.candidateevaluation.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {

    List<Evaluation> findByEvaluatorName(String evaluatorName);

    Optional<Evaluation> findByCandidateId(Long candidateId);

    List<Evaluation> findByEvaluationStatus(Evaluation.EvaluationStatus status);

    List<Evaluation> findByDeploymentStatus(Evaluation.DeploymentStatus status);

    @Query("SELECT e FROM Evaluation e WHERE e.completedAt IS NOT NULL")
    List<Evaluation> findCompletedEvaluations();

    @Query("SELECT COUNT(e) FROM Evaluation e WHERE e.evaluationStatus = 'PENDING'")
    long countPendingEvaluations();
}