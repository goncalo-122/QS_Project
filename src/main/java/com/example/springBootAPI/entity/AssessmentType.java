package com.example.springBootAPI.entity;

import jakarta.persistence.*;

/**
 * @author vss
 * @version 1.0
 * AssessmentType class represents AssessmentType entity to be mapped to database
 */

@Entity
@Table(name = "AssessmentType")
public class AssessmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long at_id; // Assessment type id

    @Column(nullable = false)
    private String at_dscr; // Assessment type description

    public AssessmentType(Long at_id, String at_dscr) {
        this.at_id = at_id;
        this.at_dscr = at_dscr;
    }

    public Long getAt_id() {
        return at_id;
    }

    public void setAt_id(Long at_id) {
        this.at_id = at_id;
    }

    public String getAt_dscr() {
        return at_dscr;
    }

    public void setAt_dscr(String at_dscr) {
        this.at_dscr = at_dscr;
    }
}
