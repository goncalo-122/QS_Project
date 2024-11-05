package com.example.springBootAPI.entities;
import jakarta.persistence.*;
@Entity
@Table(name = "map")
public class Map {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long m_id;//MAP ID

    @Column(nullable = false)
    private Long m_s_id;//semester ID -(foreign key)

    @Column(nullable = false)
    private Long m_p_id;// Period ID -(foreign key)

    @Column(nullable = false)
    private Long m_d_id;// Degree ID -(foreign key)

    @Column(nullable = false)
    private Long m_u_id;// User ID -(foreign key)

    @Column(nullable = false)
    private  String  m_lectiveyear;// lective year

    public Map(long m_id, Long m_s_id, Long m_p_id, Long m_d_id, Long m_u_id, String m_lectiveyear) {
        this.m_id = m_id;
        this.m_s_id = m_s_id;
        this.m_p_id = m_p_id;
        this.m_d_id = m_d_id;
        this.m_u_id = m_u_id;
        this.m_lectiveyear = m_lectiveyear;
    }

    public long getM_id() {
        return m_id;
    }

    public void setM_id(long m_id) {
        this.m_id = m_id;
    }

    public Long getM_s_id() {
        return m_s_id;
    }

    public void setM_s_id(Long m_s_id) {
        this.m_s_id = m_s_id;
    }

    public Long getM_p_id() {
        return m_p_id;
    }

    public void setM_p_id(Long m_p_id) {
        this.m_p_id = m_p_id;
    }

    public Long getM_d_id() {
        return m_d_id;
    }

    public void setM_d_id(Long m_d_id) {
        this.m_d_id = m_d_id;
    }

    public Long getM_u_id() {
        return m_u_id;
    }

    public void setM_u_id(Long m_u_id) {
        this.m_u_id = m_u_id;
    }

    public String getM_lectiveyear() {
        return m_lectiveyear;
    }

    public void setM_lectiveyear(String m_lectiveyear) {
        this.m_lectiveyear = m_lectiveyear;
    }
}