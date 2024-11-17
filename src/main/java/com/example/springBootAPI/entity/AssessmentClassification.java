package com.example.springBootAPI.entity;
import jakarta.persistence.*;

/**
 * @author vss
 * @version 1.0
 * AssessmentClassification class represents AssessmentClassification entity to be mapped to database
 */

@Entity
@Table(name = "assessment_classification")
public class AssessmentClassification {
    @Id
    @Column(name = "ac_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Assessment classification id

    @Column(name = "ac_dscr", nullable = false)
    private String description; // Assessment classification description

    public AssessmentClassification() {

    }

    public AssessmentClassification(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
