package com.example.springBootAPI.entities;
import jakarta.persistence.*;
public class UserType {
    @Entity
    @Table(name = "usertype")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ut_id;//UserType ID

    @Column(nullable = false)
    private String ut_dscr;//userType description

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