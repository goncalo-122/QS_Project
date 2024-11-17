package com.example.springBootAPI.entity;

import jakarta.persistence.*;

/**
 * @author vss
 * @version 1.0
 * AssessmentType class represents AssessmentType entity to be mapped to database
 */

@Entity
@Table(name = "assessment_type")
public class AssessmentType {
    @Id
    @Column(name = "at_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Assessment type id

    @Column(name = "at_dscr", nullable = false)
    private String description; // Assessment type description

    public AssessmentType() {

    }

    public AssessmentType(Long id, String description) {
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
