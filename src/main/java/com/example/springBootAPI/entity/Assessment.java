package com.example.springBootAPI.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author vss
 * @version 1.0
 * Assessment class represents Assessment entity to be mapped to database
 */
@Entity
@Table(name = "assessment")
public class Assessment {
    @Id
    @Column(name = "a_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long a_id; // Assessment id

    @ManyToOne
    @JoinColumn(name = "a_uc_id", nullable = false)
    private CurricularUnit curricularUnit; // UC of the assessment (foreign key)

    @ManyToOne
    @JoinColumn(name = "a_ac_id", nullable = false)
    private AssessmentClassification assessmentClassification; // Assessment classification (foreign key)

    @Column(name = "a_weight", nullable = false)
    private Double weight; // Assessment weight

    @Column(name = "a_date", nullable = false)
    private LocalDate date; // Assessment date

    @Column(name = "a_time", nullable = false)
    private LocalTime time; // Assessment time

    @Column(name = "a_classroom", nullable = false)
    private String classroom; // Assessment room

    public Assessment() {

    }

    public Assessment(Long a_id, CurricularUnit curricularUnit, AssessmentClassification assessmentClassification, Double weight, LocalDate date, LocalTime time, String classroom) {
        this.a_id = a_id;
        this.curricularUnit = curricularUnit;
        this.assessmentClassification = assessmentClassification;
        this.weight = weight;
        this.date = date;
        this.time = time;
        this.classroom = classroom;
    }

    public Long getA_id() {
        return a_id;
    }

    public void setA_id(Long a_id) {
        this.a_id = a_id;
    }

    public CurricularUnit getCurricularUnit() {
        return curricularUnit;
    }

    public void setCurricularUnit(CurricularUnit curricularUnit) {
        this.curricularUnit = curricularUnit;
    }

    public AssessmentClassification getAssessmentClassification() {
        return assessmentClassification;
    }

    public void setAssessmentClassification(AssessmentClassification assessmentClassification) {
        this.assessmentClassification = assessmentClassification;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
}
