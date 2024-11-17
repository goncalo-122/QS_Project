package com.example.springBootAPI.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * @author vss
 * @version 1.0
 * Semester class represents Semester entity to be mapped to database
 */

@Entity
@Table(name = "semester")
public class Semester {
    @Id
    @Column(name = "s_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Semester id

    @Column(name = "s_dscr", nullable = false)
    private String description; // Semester description

    @Column(name = "s_initdate", nullable = false)
    private LocalDate initialDate; // Semester initial date

    @Column(name = "s_enddate", nullable = false)
    private LocalDate endDate; // Semester end date

    public Semester(){

    }
    public Semester(Long id, String description, LocalDate initialDate, LocalDate endDate) {
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
