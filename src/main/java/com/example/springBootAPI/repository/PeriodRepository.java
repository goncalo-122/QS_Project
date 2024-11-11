package com.example.springBootAPI.repository;

import com.example.springBootAPI.entity.Degree;
import com.example.springBootAPI.entity.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Period entity.
 */

@Repository
public interface PeriodRepository extends JpaRepository<Period, Long> {
}
