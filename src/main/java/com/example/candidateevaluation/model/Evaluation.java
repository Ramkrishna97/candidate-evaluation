package com.example.candidateevaluation.model;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDateTime;

@Entity
public class Evaluation {

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;

    private String comments;
    private String feedback;
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime evaluatedAt= LocalDateTime.now();

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

    public Evaluation(String comments, String feedback, LocalDateTime evaluatedAt) {
//        this.evaluationStatus = evaluationStatus;
        this.comments = comments;
        this.feedback = feedback;
        this.evaluatedAt = evaluatedAt;
    }
}
