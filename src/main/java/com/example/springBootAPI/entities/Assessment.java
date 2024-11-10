package com.example.springBootAPI.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author vss
 * @version 1.0
 * Assessment class represents Assessment entity to be mapped to database
 */
@Entity
@Table(name = "Assessment")
public class Assessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long a_id; // Assessment id

    @Column(nullable = false)
    private Long a_uc_id; // UC of the assessment (foreign key)

    @Column(nullable = false)
    private Long a_ac_id; // Assessment classification (foreign key)

    @Column(nullable = false)
    private Double a_weight; // Assessment weight

    @Column(nullable = false)
    private LocalDate a_date; // Assessment date

    @Column(nullable = false)
    private LocalTime a_time; // Assessment time

    @Column(nullable = false)
    private String a_room; // Assessment room

    public Assessment(Long a_id, Long a_uc_id, Long a_ac_id, Double a_weight, LocalDate a_date, LocalTime a_time, String a_room) {
        this.a_id = a_id;
        this.a_uc_id = a_uc_id;
        this.a_ac_id = a_ac_id;
        this.a_weight = a_weight;
        this.a_date = a_date;
        this.a_time = a_time;
        this.a_room = a_room;
    }

    public Long getA_id() {
        return a_id;
    }

    public void setA_id(Long a_id) {
        this.a_id = a_id;
    }

    public Long getA_uc_id() {
        return a_uc_id;
    }

    public void setA_uc_id(Long a_uc_id) {
        this.a_uc_id = a_uc_id;
    }

    public Long getA_ac_id() {
        return a_ac_id;
    }

    public void setA_at_id(Long a_ac_id) {
        this.a_ac_id = a_ac_id;
    }

    public Double getA_weight() {
        return a_weight;
    }

    public void setA_weight(Double a_weight) {
        this.a_weight = a_weight;
    }

    public LocalDate getA_date() {
        return a_date;
    }

    public void setA_date(LocalDate a_date) {
        this.a_date = a_date;
    }

    public LocalTime getA_time() {
        return a_time;
    }

    public void setA_time(LocalTime a_time) {
        this.a_time = a_time;
    }

    public String getA_room() {
        return a_room;
    }

    public void setA_room(String a_room) {
        this.a_room = a_room;
    }
}
