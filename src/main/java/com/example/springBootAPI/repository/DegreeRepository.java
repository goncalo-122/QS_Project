package com.example.springBootAPI.repository;

import com.example.springBootAPI.entities.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Degree entity.
 */
@Repository
public interface DegreeRepository extends JpaRepository<Degree, Long> {

}
