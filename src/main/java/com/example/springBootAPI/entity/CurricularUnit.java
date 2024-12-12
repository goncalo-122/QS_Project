package com.example.springBootAPI.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

/**
 * @author gsn
 * @version 1.0
 * CurricularUnit class represents CurricularUnit entity to be mapped to database
 */

@Entity
@Table(name = "curricular_unit")
public class CurricularUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cu_id")
    private Long id;

    @OneToMany(mappedBy = "curricularUnit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Assessment> assessments;

    @ManyToOne
    @JoinColumn(name = "cu_d_id", nullable = false)
    @JsonIgnoreProperties({"maps", "curricularUnits"})
    private Degree degree;

    @ManyToOne
    @JoinColumn(name = "cu_at_id", nullable = false)
    private AssessmentType assessmentType;

    @ManyToOne
    @JoinColumn(name = "cu_s_id", nullable = false)
    private Semester semester;

    @Column(name = "cu_dscr", nullable = false)
    private String description;

    @Column(name = "cu_year", nullable = false)
    private String year;

    @Column(name = "cu_attend", nullable = false)
    private Boolean attendance;

    public CurricularUnit() {

    }

    public CurricularUnit(Long id, List<Assessment> assessments, Degree degree, AssessmentType assessmentType, Semester semester, String description, String year, Boolean attendance) {
        this.id = id;
        this.assessments = assessments;
        this.degree = degree;
        this.assessmentType = assessmentType;
        this.semester = semester;
        this.description = description;
        this.year = year;
        this.attendance = attendance;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Assessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<Assessment> assessments) {
        this.assessments = assessments;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public AssessmentType getAssessmentType() {
        return assessmentType;
    }

    public void setAssessmentType(AssessmentType assessmentType) {
        this.assessmentType = assessmentType;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Boolean getAttendance() {
        return attendance;
    }

    public void setAttendance(Boolean attendance) {
        this.attendance = attendance;
    }
}