package com.example.springBootAPI.entity;
import jakarta.persistence.*;

/**
 * @author gsn
 * @version 1.0
 * UserType class represents UserType entity to be mapped to database
 */

@Entity
@Table(name = "user_type")
public class UserType {

    @Id
    @Column(name = "ut_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // User type id

    @Column(name = "ut_dscr", nullable = false)
    private String description; // Description

    public UserType(){

    }

    public UserType(Long id, String description) {
        this.id = id;
        this.description = description;
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
}