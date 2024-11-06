package com.example.springBootAPI.entities;
import jakarta.persistence.*;
@Entity
@Table(name = "cu")
//CU=Curricular Unit
public class Cu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cu_id;//CU ID

    @Column(nullable = false)
    private Long cu_d_id;//Degree ID -(foreign key)

    @Column(nullable = false)
    private Long  cu_at_id;//Assessment type Id-(foreign key)

    @Column(nullable = false)
    private Long cu_s_id;//UC Semester-(foreign key)

    @Column(nullable = false)
    private String cu_dscr;//Cu description

    @Column(nullable = false)
    private String cu_year;//CU Year


    @Column(nullable = false)
    private Long cu_attent;//CU Attendance

    public Cu(Long cu_id, Long cu_d_id, Long cu_at_id, Long cu_s_id, String cu_dscr, String cu_year, Long cu_attent) {
        this.cu_id = cu_id;
        this.cu_d_id = cu_d_id;
        this.cu_at_id = cu_at_id;
        this.cu_s_id = cu_s_id;
        this.cu_dscr = cu_dscr;
        this.cu_year = cu_year;
        this.cu_attent = cu_attent;
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

    public Long getCu_attent() {
        return cu_attent;
    }

    public void setCu_attent(Long cu_attent) {
        this.cu_attent = cu_attent;
    }
}