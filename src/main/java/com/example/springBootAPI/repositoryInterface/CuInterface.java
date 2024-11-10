package com.example.springbootapi.repository;

import com.example.springbootapi.entity.Cu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Cu entity.
 */
@Repository
public interface CuRepository extends JpaRepository<Cu, Long> {
}