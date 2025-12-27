package com.example.candidateevaluation.model;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDateTime;

@Entity
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;
    @Column(length = 4000)
    private String comments;
    @Column(length = 4000)
    private String feedback;
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime evaluatedAt= LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private Candidate.EvaluationStatus evaluationStatus = Candidate.EvaluationStatus.PENDING;

    private LocalDateTime assignedAt = LocalDateTime.now();
    private LocalDateTime completedAt;

    public enum DeploymentStatus {
        PENDING, IN_PROGRESS, DEPLOYED, FAILED
    }

    public enum EvaluationStatus {
        PENDING, IN_REVIEW, ACCEPTED, REJECTED, NEEDS_REVISION
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }


    public Evaluation() {
    }
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public LocalDateTime getEvaluatedAt() {
        return evaluatedAt;
    }

    public void setEvaluatedAt(LocalDateTime evaluatedAt) {
        this.evaluatedAt = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Candidate.EvaluationStatus getEvaluationStatus() {
        return evaluationStatus;
    }

    public void setEvaluationStatus(Candidate.EvaluationStatus evaluationStatus) {
        this.evaluationStatus = evaluationStatus;
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(LocalDateTime assignedAt) {
        this.assignedAt = assignedAt;
    }

    public Evaluation(long id, Candidate candidate, String comments, String feedback, LocalDateTime evaluatedAt, Candidate.EvaluationStatus evaluationStatus, LocalDateTime assignedAt, LocalDateTime completedAt) {
        this.id = id;
        this.candidate = candidate;
        this.comments = comments;
        this.feedback = feedback;
        this.evaluatedAt = evaluatedAt;
        this.evaluationStatus = evaluationStatus;
        this.assignedAt = assignedAt;
        this.completedAt = completedAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }
}
