package com.example.springBootAPI.entities;
import jakarta.persistence.*;
public class User {
    @Entity
    @Table(name = "user")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long u_id;//User ID

    @Column(nullable = false)
    private String u_ut_id;//user type id-(foreign key)

    @Column(nullable = false)
    private String u_email;//user email

    @Column(nullable = false)
    private String u_pass;//user password


    public User(Long u_id, String u_ut_id, String u_email, String u_pass) {
        this.u_id = u_id;
        this.u_ut_id = u_ut_id;
        this.u_email = u_email;
        this.u_pass = u_pass;
    }


    public Long getU_id() {
        return u_id;
    }

    public void setU_id(long u_id) {
        this.u_id = u_id;
    }

    public String getU_ut_id() {
        return u_ut_id;
    }

    public void setU_ut_id(String u_ut_id) {
        this.u_ut_id = u_ut_id;
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public String getU_pass() {
        return u_pass;
    }

    public void setU_pass(String u_pass) {
        this.u_pass = u_pass;
    }
}