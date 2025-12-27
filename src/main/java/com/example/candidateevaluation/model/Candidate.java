package com.example.candidateevaluation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Candidate {
    @Id
    private long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String skillSet;
    private String location;
    private int experienceInYears;
    private String designation;
    private String evaluationStatus;
}
