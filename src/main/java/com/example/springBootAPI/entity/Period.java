package com.example.springBootAPI.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * @author vss
 * @version 1.0
 * Period class represents Period entity to be mapped to database
 */

@Entity
@Table(name = "period")
public class Period {
    @Id
    @Column(name = "p_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Period id

    @Column(name = "p_dscr", nullable = false)
    private String description; // Period description

    @Column(name = "p_initdate", nullable = false)
    private LocalDate initialDate; // Period initial date

    @Column(name = "p_enddate", nullable = false)
    private LocalDate endDate; // Period end date

    public Period() {

    }

    public Period(Long id, String description, LocalDate initialDate, LocalDate endDate) {
        this.id = id;
        this.description = description;
        this.initialDate = initialDate;
        this.endDate = endDate;
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

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDate initialDate) {
        this.initialDate = initialDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
