package com.example.springBootAPI.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "u_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // User id

    @ManyToOne
    @JoinColumn(name = "u_ut_id", nullable = false)
    private UserType type; // User type (foreign key)

    @Column(name = "u_email", nullable = false)
    private String email; // User email

    @Column(name = "u_password", nullable = false)
    private String password; // User password

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"degree", "user", "assessments"})
    private List<Map> maps;

    public User() {
    }

    public User(Long id, UserType type, String email, String password, List<Map> maps) {
        this.id = id;
        this.type = type;
        this.email = email;
        this.password = password;
        this.maps = maps;
    }

    // Getters and setters...

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

    public List<Map> getMaps() {
        return maps;
    }

    public void setMaps(List<Map> maps) {
        this.maps = maps;
    }

    // Utility methods
    public void addMap(Map map) {
        maps.add(map);
        map.setUser(this); // Set the user reference in Map
    }

    public void removeMap(Map map) {
        maps.remove(map);
        map.setUser(null); // Clear the user reference in Map
    }
}
