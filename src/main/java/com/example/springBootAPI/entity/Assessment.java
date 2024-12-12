package com.example.springBootAPI.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private Long id;

    @ManyToOne
    @JoinColumn(name = "a_cu_id", nullable = false)
    @JsonIgnoreProperties({"assessments", "degree"})
    private CurricularUnit curricularUnit;

    @ManyToOne
    @JoinColumn(name = "a_m_id", nullable = false)
    @JsonIgnoreProperties({"assessments", "degree"})
    private Map map;

    @ManyToOne
    @JoinColumn(name = "a_ac_id", nullable = false)
    private AssessmentClassification assessmentClassification;

    @Column(name = "a_weight", nullable = false)
    private Double weight;

    @Column(name = "a_date", nullable = false)
    private LocalDate date;

    @Column(name = "a_time", nullable = false)
    private LocalTime time;

    @Column(name = "a_classroom", nullable = false)
    private String classroom;

    public Assessment() {

    }

    public Assessment(Long id, CurricularUnit curricularUnit, AssessmentClassification assessmentClassification, Double weight, LocalDate date, LocalTime time, String classroom) {
        this.id = id;
        this.curricularUnit = curricularUnit;
        this.assessmentClassification = assessmentClassification;
        this.weight = weight;
        this.date = date;
        this.time = time;
        this.classroom = classroom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
