package com.example.springBootAPI.entities;
import jakarta.persistence.*;
@Entity
@Table(name = "uc")
public class Uc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uc_id;//UC ID

    @Column(nullable = false)
    private Long uc_d_id;//Degree ID -(foreign key)

    @Column(nullable = false)
    private Long  uc_at_id;//Assessment type Id-(foreign key)

    @Column(nullable = false)
    private Long uc_s_id;//UC Semester-(foreign key)

    
    @Column(nullable = false)
    private String uc_dscr;//UC description

    @Column(nullable = false)
    private String uc_year;//UC Year


    @Column(nullable = false)
    private Long uc_attent;//UC Attendance

    public Uc(long uc_id, Long uc_d_id, Long uc_at_id, Long uc_s_id, String uc_dscr, String uc_year, Long uc_attent) {
        this.uc_id = uc_id;
        this.uc_d_id = uc_d_id;
        this.uc_at_id = uc_at_id;
        this.uc_s_id = uc_s_id;
        this.uc_dscr = uc_dscr;
        this.uc_year = uc_year;
        this.uc_attent = uc_attent;
    }

    public long getUc_id() {
        return uc_id;
    }

    public void setUc_id(long uc_id) {
        this.uc_id = uc_id;
    }

    public Long getUc_d_id() {
        return uc_d_id;
    }

    public void setUc_d_id(Long uc_d_id) {
        this.uc_d_id = uc_d_id;
    }

    public Long getUc_at_id() {
        return uc_at_id;
    }

    public void setUc_at_id(Long uc_at_id) {
        this.uc_at_id = uc_at_id;
    }

    public Long getUc_s_id() {
        return uc_s_id;
    }

    public void setUc_s_id(Long uc_s_id) {
        this.uc_s_id = uc_s_id;
    }

    public String getUc_dscr() {
        return uc_dscr;
    }

    public void setUc_dscr(String uc_dscr) {
        this.uc_dscr = uc_dscr;
    }

    public String getUc_year() {
        return uc_year;
    }

    public void setUc_year(String uc_year) {
        this.uc_year = uc_year;
    }

    public Long getUc_attent() {
        return uc_attent;
    }

    public void setUc_attent(Long uc_attent) {
        this.uc_attent = uc_attent;
    }
}