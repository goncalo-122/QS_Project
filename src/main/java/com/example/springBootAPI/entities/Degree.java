package com.example.springBootAPI.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "degree")
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Degree id

    @Column(nullable = false)
    private String dscr; // Degree description


    public Degree(Long c_id, String c_dscr) {
        this.id = c_id;
        this.dscr = c_dscr;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDscr() {
        return dscr;
    }

    public void setDscr(String dscr) {
        this.dscr = dscr;
    }
}
