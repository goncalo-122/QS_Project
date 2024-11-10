package com.example.springBootAPI.repository;

import com.example.springBootAPI.entity.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Map entity.
 */

@Repository
public interface MapRepository extends JpaRepository<Degree, Long> {
}
