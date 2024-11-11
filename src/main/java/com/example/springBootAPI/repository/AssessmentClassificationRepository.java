package com.example.springBootAPI.repository;

import com.example.springBootAPI.entity.AssessmentClassification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for AssessmentClassification entity.
 */

@Repository
public interface AssessmentClassificationRepository extends JpaRepository<AssessmentClassification, Long> {
}
