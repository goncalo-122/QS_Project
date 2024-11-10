package com.example.springBootAPI.entity;
import jakarta.persistence.*;

/**
 * @author gsn
 * @version 1.0
 * CurricularUnit class represents CurricularUnit entity to be mapped to database
 */

@Entity
@Table(name = "CurricularUnit")
public class CurricularUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cu_id; // Curricular unit id

    @Column(nullable = false)
    private Long cu_d_id; // Degree id (foreign key)

    @Column(nullable = false)
    private Long  cu_at_id; // Assessment type id (foreign key)

    @Column(nullable = false)
    private Long cu_s_id; //  Semester (foreign key)

    @Column(nullable = false)
    private String cu_dscr; // Curricular unit description

    @Column(nullable = false)
    private String cu_year; // Year

    @Column(nullable = false)
    private Double cu_attend; // Attendance

    public CurricularUnit(Long cu_id, Long cu_d_id, Long cu_at_id, Long cu_s_id, String cu_dscr, String cu_year, Double cu_attend) {
        this.cu_id = cu_id;
        this.cu_d_id = cu_d_id;
        this.cu_at_id = cu_at_id;
        this.cu_s_id = cu_s_id;
        this.cu_dscr = cu_dscr;
        this.cu_year = cu_year;
        this.cu_attend = cu_attend;
    }


    public Long getCu_id() {
        return cu_id;
    }

    public void setCu_id(Long cu_id) {
        this.cu_id = cu_id;
    }

    public Long getCu_d_id() {
        return cu_d_id;
    }

    public void setCu_d_id(Long cu_d_id) {
        this.cu_d_id = cu_d_id;
    }

    public Long getCu_at_id() {
        return cu_at_id;
    }

    public void setCu_at_id(Long cu_at_id) {
        this.cu_at_id = cu_at_id;
    }

    public Long getCu_s_id() {
        return cu_s_id;
    }

    public void setCu_s_id(Long cu_s_id) {
        this.cu_s_id = cu_s_id;
    }

    public String getCu_dscr() {
        return cu_dscr;
    }

    public void setCu_dscr(String cu_dscr) {
        this.cu_dscr = cu_dscr;
    }

    public String getCu_year() {
        return cu_year;
    }

    public void setCu_year(String cu_year) {
        this.cu_year = cu_year;
    }

    public Double getCu_attend() {
        return cu_attend;
    }

    public void setCu_attend(Double cu_attend) {
        this.cu_attend = cu_attend;
    }
}