package com.example.candidateevaluation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.ValueGenerationType;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Time;
@Entity
public class Evaluation {
    private String comments;
    private String feedback;
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Time evaluatedAt;

    public Evaluation() {
    }

    public Evaluation(String comments, String feedback, Time evaluatedAt) {
        this.comments = comments;
        this.feedback = feedback;
        this.evaluatedAt = evaluatedAt;
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

    public Time getEvaluatedAt() {
        return evaluatedAt;
    }

    public void setEvaluatedAt(Time evaluatedAt) {
        this.evaluatedAt = evaluatedAt;
    }
}
