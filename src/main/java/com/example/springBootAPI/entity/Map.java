package com.example.springBootAPI.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

/**
 * @author gsn
 * @version 1.0
 * Map class represents Map entity to be mapped to database
 */

@Entity
@Table(name = "map")
public class Map {
    @Id
    @Column(name = "m_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Map id

    @OneToMany(mappedBy = "map", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CurricularUnit> curricularUnits;

//    @ManyToOne
//    @JoinColumn(name = "m_u_id", nullable = false)
//    private User user; // User id (foreign key)

    @ManyToOne
    @JoinColumn(name = "m_s_id", nullable = false)
    private Semester semester; //semester id (foreign key)

    @ManyToOne
    @JoinColumn(name = "m_p_id", nullable = false)
    private Period period; // Period id (foreign key)

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "m_d_id", nullable = false)
    private Degree degree; // Degree id (foreign key)

    @Column(name = "m_lectiveyear", nullable = false)
    private  String lectiveyear; // lective year

    public Map() {

    }

    public Map(long id, List<CurricularUnit> curricularUnits,  Semester semester, Period period, Degree degree /*User user*/, String lectiveyear) {
        this.id = id;
        this.curricularUnits = curricularUnits;
        this.semester = semester;
        this.period = period;
        this.degree = degree;
//        this.user = user;
        this.lectiveyear = lectiveyear;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<CurricularUnit> getCurricularUnits() {
        return curricularUnits;
    }

    public void setCurricularUnits(List<CurricularUnit> curricularUnits) {
        this.curricularUnits = curricularUnits;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public String getLectiveyear() {
        return lectiveyear;
    }

    public void setLectiveyear(String lectiveyear) {
        this.lectiveyear = lectiveyear;
    }
}