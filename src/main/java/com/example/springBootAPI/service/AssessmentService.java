package com.example.springBootAPI.service;

import com.example.springBootAPI.entity.Assessment;
import com.example.springBootAPI.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @version 1.0
 * Service class for managing Assessment entities.
 */

@Service
public class AssessmentService {

    private final AssessmentRepository assessmentRepository;

    @Autowired
    public AssessmentService(AssessmentRepository assessmentRepository) {
        this.assessmentRepository = assessmentRepository;
    }

    /**
     * Save assessment.
     *
     * @param assessment the entity to save
     * @return the persisted entity
     */
    public Assessment saveAssessment(Assessment assessment) {
        return assessmentRepository.save(assessment);
    }

    /**
     * Get all the Assessments.
     *
     * @return the list of entities
     */
    public List<Assessment> getAllAssessments() {
        return assessmentRepository.findAll();
    }

    /**
     * Get one assessment by ID.
     *
     * @param id the ID of the entity
     * @return the entity
     */
    public Optional<Assessment> getAssessmentById(Long id) {
        return assessmentRepository.findById(id);
    }

    /**
     * Update a assessment.
     *
     * @param id the ID of the entity
     * @param updatedAssessment the updated entity
     * @return the updated entity
     */
    public Assessment updateAssessment(Long id, Assessment updatedAssessment) {
        Optional<Assessment> existingAssessment = assessmentRepository.findById(id);
        if (existingAssessment.isPresent()) {
            Assessment assessment = existingAssessment.get();
            assessment.setA_ac_id(updatedAssessment.getA_ac_id());
            assessment.setA_uc_id(updatedAssessment.getA_uc_id());
            assessment.setA_date(updatedAssessment.getA_date());
            assessment.setA_time(updatedAssessment.getA_time());
            assessment.setA_room(updatedAssessment.getA_room());
            assessment.setA_weight(updatedAssessment.getA_weight());
            return assessmentRepository.save(assessment);
        } else {
            throw new RuntimeException("Assessment not found");
        }
    }

    /**
     * Delete the assessment by ID.
     *
     * @param id the ID of the entity
     */
    public void deleteAssessment(Long id) {
        assessmentRepository.deleteById(id);
    }
}
