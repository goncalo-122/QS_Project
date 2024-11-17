package com.example.springBootAPI.service;

import com.example.springBootAPI.entity.AssessmentClassification;
import com.example.springBootAPI.repository.AssessmentClassificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @version 1.0
 * Service class for managing AssessmentClassification entities.
 */

@Service
public class AssessmentClassificationService {

    private final AssessmentClassificationRepository assessmentClassificationRepository;

    @Autowired
    public AssessmentClassificationService(AssessmentClassificationRepository assessmentClassificationRepository) {
        this.assessmentClassificationRepository = assessmentClassificationRepository;
    }

    /**
     * Save a assessmentClassification.
     *
     * @param assessmentClassification the entity to save
     * @return the persisted entity
     */
    public AssessmentClassification saveAssessmentClassification(AssessmentClassification assessmentClassification) {
        return assessmentClassificationRepository.save(assessmentClassification);
    }

    /**
     * Get all the assessment classifications.
     *
     * @return the list of entities
     */
    public List<AssessmentClassification> getAllAssessmentClassifications() {
        return assessmentClassificationRepository.findAll();
    }

    /**
     * Get one assessment classification by ID.
     *
     * @param id the ID of the entity
     * @return the entity
     */
    public Optional<AssessmentClassification> getAssessmentClassificationById(Long id) {
        return assessmentClassificationRepository.findById(id);
    }

    /**
     * Update a assessment classification.
     *
     * @param id the ID of the entity
     * @param updatedAssessmentClassification the updated entity
     * @return the updated entity
     */
    public AssessmentClassification updateAssessmentClassification(Long id, AssessmentClassification updatedAssessmentClassification) {
        Optional<AssessmentClassification> existingAssessmentClassification = assessmentClassificationRepository.findById(id);
        if (existingAssessmentClassification.isPresent()) {
            AssessmentClassification assessmentClassification = existingAssessmentClassification.get();
            assessmentClassification.setDescription(updatedAssessmentClassification.getDescription());
            return assessmentClassificationRepository.save(assessmentClassification);
        } else {
            throw new RuntimeException("Assessment classification not found");
        }
    }

    /**
     * Delete the assessment classification by ID.
     *
     * @param id the ID of the entity
     */
    public void deleteAssessmentClassification(Long id) {
        assessmentClassificationRepository.deleteById(id);
    }
}
