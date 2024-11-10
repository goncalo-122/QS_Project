package com.example.springBootAPI.entities;
import jakarta.persistence.*;

/**
 * @author vss
 * @version 1.0
 * AssessmentClassification class represents AssessmentClassification entity to be mapped to database
 */

@Entity
@Table(name = "AssessmentClassification")
public class AssessmentClassification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ac_id; // Assessment classification id

    @Column(nullable = false)
    private String ac_dscr; // Assessment classification description

    public AssessmentClassification(Long ac_id, String ac_dscr) {
        this.ac_id = ac_id;
        this.ac_dscr = ac_dscr;
    }

    public Long getAc_id() {
        return ac_id;
    }

    public void setAc_id(Long ac_id) {
        this.ac_id = ac_id;
    }

    public String getAc_dscr() {
        return ac_dscr;
    }

    public void setAc_dscr(String ac_dscr) {
        this.ac_dscr = ac_dscr;
    }
}
