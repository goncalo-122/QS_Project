package com.example.springBootAPI.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

/**
 * @author vss
 * @version 1.0
 * Period class represents Period entity to be mapped to database
 */
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long p_id; // Period id

    @Column(nullable = false)
    private String p_dscr; // Period description

    @Column(nullable = false)
    private LocalDate p_initdate; // Period initial date

    @Column(nullable = false)
    private LocalDate p_enddate; // Period end date

    public Period(Long p_id, String p_dscr, LocalDate p_initdate, LocalDate p_enddate) {
        this.p_id = p_id;
        this.p_dscr = p_dscr;
        this.p_initdate = p_initdate;
        this.p_enddate = p_enddate;
    }

    public Long getP_id() {
        return p_id;
    }

    public void setP_id(Long p_id) {
        this.p_id = p_id;
    }

    public String getP_dscr() {
        return p_dscr;
    }

    public void setP_dscr(String p_dscr) {
        this.p_dscr = p_dscr;
    }

    public LocalDate getP_initdate() {
        return p_initdate;
    }

    public void setP_initdate(LocalDate p_initdate) {
        this.p_initdate = p_initdate;
    }

    public LocalDate getP_enddate() {
        return p_enddate;
    }

    public void setP_enddate(LocalDate p_enddate) {
        this.p_enddate = p_enddate;
    }
}
