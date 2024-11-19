package com.example.springBootAPI.entity;
import jakarta.persistence.*;

import java.util.List;

/**
 * @author gsn
 * @version 1.0
 * User class represents User entity to be mapped to database
 */

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "u_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // User id

    @ManyToOne
    @JoinColumn(name = "u_ut_id", nullable = false)
    private UserType type; // user type (foreign key)

    @Column(name = "u_email", nullable = false)
    private String email; // user email

    @Column(name = "u_password", nullable = false)
    private String password; // user password

    public User(){

    }

    public User(Long id, UserType type, String email, String password) {
        this.id = id;
        this.type = type;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}