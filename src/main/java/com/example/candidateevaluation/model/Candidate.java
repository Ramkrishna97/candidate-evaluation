package com.example.candidateevaluation.model;

import jakarta.persistence.*;
import com.example.candidateevaluation.model.Evaluation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String phoneNumber;
    @Column(name="skill_set")
    private String skillSet;
    private String location;
    @Column(name="experience_in_years")
    private int experienceInYears;
    private String designation;

        @Enumerated(EnumType.STRING)
            private EvaluationStatus evaluationStatus = EvaluationStatus.PENDING;

        private LocalDateTime createdAt = LocalDateTime.now();

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    private LocalDateTime updatedAt = LocalDateTime.now();

            @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
            private List<Evaluation> evaluations = new ArrayList<>();

            public enum EvaluationStatus {
            PENDING, ASSIGNED, IN_PROGRESS, COMPLETED, REJECTED, SELECTED
    }
    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", skillSet='" + skillSet + '\'' +
                ", location='" + location + '\'' +
                ", experienceInYears=" + experienceInYears +
                ", designation='" + designation + '\'' +
                ", evaluationStatus='" + evaluationStatus + '\'' +
                '}';
    }

    public Candidate() {
    }

    public Candidate(long id, String name, String email, String phoneNumber, String skillSet, String location, int experienceInYears, String designation, EvaluationStatus evaluationStatus, LocalDateTime createdAt, LocalDateTime updatedAt, List<Evaluation> evaluations) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.skillSet = skillSet;
        this.location = location;
        this.experienceInYears = experienceInYears;
        this.designation = designation;
        this.evaluationStatus = evaluationStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.evaluations = evaluations;
    }

    public Candidate(long id, String name, String email, String phoneNumber, String skillSet, String location, int experienceInYears, String designation, EvaluationStatus status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.skillSet = skillSet;
        this.location = location;
        this.experienceInYears = experienceInYears;
        this.designation = designation;
        this.evaluationStatus = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(String skillSet) {
        this.skillSet = skillSet;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getExperienceInYears() {
        return experienceInYears;
    }

    public void setExperienceInYears(int experienceInYears) {
        this.experienceInYears = experienceInYears;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }


    public EvaluationStatus getEvaluationStatus() {
        return evaluationStatus;
    }

    public void setEvaluationStatus(EvaluationStatus evaluationStatus) {
        this.evaluationStatus = evaluationStatus;
    }

}
