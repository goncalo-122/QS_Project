package com.example.springBootAPI.entities;
import jakarta.persistence.*;

/**
 * @author vss
 * @version 1.0
 * Degree class represents Degree entity to be mapped to database
 */

@Entity
@Table(name = "Degree")
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long d_id; // Degree id

    @Column(nullable = false)
    private String d_dscr; // Degree description


    public Degree(Long d_id, String d_dscr) {
        this.d_id = d_id;
        this.d_dscr = d_dscr;
    }


    public Long getId() {
        return d_id;
    }

    public void setId(Long id) {
        this.d_id = id;
    }

    public String getDscr() {
        return d_dscr;
    }

    public void setDscr(String dscr) {
        this.d_dscr = d_dscr;
    }
}
