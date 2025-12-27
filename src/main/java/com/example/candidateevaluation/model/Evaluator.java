package com.example.candidateevaluation.model;

import jakarta.persistence.*;

@Entity
public class Evaluator {
    @Id
    private String name;
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    public Candidate getCandidate() {
        return candidate;
    }

    public Evaluator() {
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Evaluator(String name, Candidate candidate) {
        this.name = name;
        this.candidate = candidate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
