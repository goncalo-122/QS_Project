package com.example.springBootAPI.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "map")
public class Map {

    @Id
    @Column(name = "m_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "map", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Assessment> assessments;

//    @ManyToOne
//    @JoinColumn(name = "m_u_id", nullable = false)
//    private User user;

    @ManyToOne
    @JoinColumn(name = "m_s_id", nullable = false)
    private Semester semester;

    @ManyToOne
    @JoinColumn(name = "m_p_id", nullable = false)
    private Period period;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "m_d_id", nullable = false)
    @JsonIgnoreProperties({"maps"})
    private Degree degree;

    @Column(name = "m_lectiveyear", nullable = false)
    private String lectiveyear;

    public Map() {
    }

    public Map(long id,Semester semester, Period period, Degree degree, String lectiveyear) {
        this.id = id;
//        this.user = user;
        this.semester = semester;
        this.period = period;
        this.degree = degree;
        this.lectiveyear = lectiveyear;
    }

    // Getters and setters...

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public String getLectiveyear() {
        return lectiveyear;
    }

    public void setLectiveyear(String lectiveyear) {
        this.lectiveyear = lectiveyear;
    }

    public List<Assessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<Assessment> assessments) {
        this.assessments = assessments;
    }

    public void addAssessment(Assessment assessment) {
        this.assessments.add(assessment);
        assessment.setMap(this);
    }

    public void removeAssessment(Assessment assessment) {
        this.assessments.remove(assessment);
        assessment.setMap(null);
    }
}
