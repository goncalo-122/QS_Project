package com.example.springBootAPI.entity;
import jakarta.persistence.*;

/**
 * @author gsn
 * @version 1.0
 * UserType class represents UserType entity to be mapped to database
 */

@Entity
@Table(name = "UserType")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ut_id; // User type id

    @Column(nullable = false)
    private String ut_dscr; // Description

    public UserType(String ut_id, String ut_dscr) {
        this.ut_id = ut_id;
        this.ut_dscr = ut_dscr;
    }


    public String getUt_id() {
        return ut_id;
    }

    public void setUt_id(String ut_id) {
        this.ut_id = ut_id;
    }

    public String getUt_dscr() {
        return ut_dscr;
    }

    public void setUt_dscr(String ut_dscr) {
        this.ut_dscr = ut_dscr;
    }
}