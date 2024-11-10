package com.example.springBootAPI.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * @author vss
 * @version 1.0
 * Semester class represents Semester entity to be mapped to database
 */

@Entity
@Table(name = "Semester")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long s_id; // Semester id

    @Column(nullable = false)
    private String s_dscr; // Semester description

    @Column(nullable = false)
    private LocalDate s_initdate; // Semester initial date

    @Column(nullable = false)
    private LocalDate s_enddate; // Semester end date

    public Semester(Long s_id, String s_dscr, LocalDate s_initdate, LocalDate s_enddate) {
        this.s_id = s_id;
        this.s_dscr = s_dscr;
        this.s_initdate = s_initdate;
        this.s_enddate = s_enddate;
    }

    public Long getS_id() {
        return s_id;
    }

    public void setS_id(Long s_id) {
        this.s_id = s_id;
    }

    public String getS_dscr() {
        return s_dscr;
    }

    public void setS_dscr(String s_dscr) {
        this.s_dscr = s_dscr;
    }

    public LocalDate getS_initdate() {
        return s_initdate;
    }

    public void setS_initdate(LocalDate s_initdate) {
        this.s_initdate = s_initdate;
    }

    public LocalDate getS_enddate() {
        return s_enddate;
    }

    public void setS_enddate(LocalDate s_enddate) {
        this.s_enddate = s_enddate;
    }
}
