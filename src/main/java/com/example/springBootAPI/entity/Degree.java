package com.example.springBootAPI.entity;
import jakarta.persistence.*;

/**
 * @author vss
 * @version 1.0
 * Degree class represents Degree entity to be mapped to database
 */

@Entity
@Table(name = "degree")
public class Degree {
    @Id
    @Column(name = "d_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Degree id

    @Column(name = "d_dscr", nullable = false)
    private String description; // Degree description

    public Degree() {

    }

    public Degree(Long id, String description) {
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
