package com.example.springBootAPI.entity;
import jakarta.persistence.*;

import java.util.List;

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

    @OneToMany(mappedBy = "degree", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Map> maps;

    @Column(name = "d_dscr", nullable = false)
    private String description; // Degree description

    public Degree() {

    }

    public Degree(Long id, List<Map> maps, String description) {
        this.id = id;
        this.maps = maps;
        this.description = description;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Map> getMaps() {
        return maps;
    }

    public void setMaps(List<Map> maps) {
        this.maps = maps;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
