package com.example.springBootAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "degree")
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "d_id")
    private Long id;

    @OneToMany(mappedBy = "degree", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"assessments", "degree"})
    private List<Map> maps;

    @OneToMany(mappedBy = "degree", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"assessments", "degree"})
    private List<CurricularUnit> curricularUnits;

    @Column(name = "d_dscr", nullable = false)
    private String description;

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

    public List<Map> getMaps() {
        return maps;
    }

    public void setMaps(List<Map> maps) {
        this.maps = maps;
    }

    public List<CurricularUnit> getCurricularUnits() {
        return curricularUnits;
    }

    public void setCurricularUnits(List<CurricularUnit> curricularUnits) {
        this.curricularUnits = curricularUnits;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    // Helper method to manage the bidirectional relationship
    public void addMap(Map map) {
        this.maps.add(map);
        map.setDegree(this);
    }

    public void removeMap(Map map) {
        this.maps.remove(map);
        map.setDegree(null);
    }

    public void addCurricularUnit(CurricularUnit curricularUnit) {
        this.curricularUnits.add(curricularUnit);
        curricularUnit.setDegree(this);
    }

    public void removeCurricularUnit(CurricularUnit curricularUnit) {
        this.maps.remove(curricularUnit);
        curricularUnit.setDegree(null);
    }
}
