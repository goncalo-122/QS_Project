package com.example.springBootAPI.service;

import com.example.springBootAPI.entity.AssessmentType;
import com.example.springBootAPI.repository.AssessmentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @version 1.0
 * Service class for managing AssessmentType entities.
 */

@Service
public class AssessmentTypeService {

    private final AssessmentTypeRepository assessmentTypeRepository;

    @Autowired
    public AssessmentTypeService(AssessmentTypeRepository assessmentTypeRepository) {
        this.assessmentTypeRepository = assessmentTypeRepository;
    }

    /**
     * Save assessment type.
     *
     * @param assessmentType the entity to save
     * @return the persisted entity
     */
    public AssessmentType saveAssessmentType(AssessmentType assessmentType) {
        return assessmentTypeRepository.save(assessmentType);
    }

    /**
     * Get all the assessment types.
     *
     * @return the list of entities
     */
    public List<AssessmentType> getAllAssessmentTypes() {
        return assessmentTypeRepository.findAll();
    }

    /**
     * Get one assessment type by ID.
     *
     * @param id the ID of the entity
     * @return the entity
     */
    public Optional<AssessmentType> getAssessmentTypeById(Long id) {
        return assessmentTypeRepository.findById(id);
    }

    /**
     * Update a assessment type.
     *
     * @param id the ID of the entity
     * @param updatedAssessmentType the updated entity
     * @return the updated entity
     */
    public AssessmentType updateAssessmentType(Long id, AssessmentType updatedAssessmentType) {
        Optional<AssessmentType> existingAssessmentType = assessmentTypeRepository.findById(id);
        if (existingAssessmentType.isPresent()) {
            AssessmentType assessmentType = existingAssessmentType.get();
            assessmentType.setAt_dscr(updatedAssessmentType.getAt_dscr());
            return assessmentTypeRepository.save(assessmentType);
        } else {
            throw new RuntimeException("Assessment type not found");
        }
    }

    /**
     * Delete the assessment type by ID.
     *
     * @param id the ID of the entity
     */
    public void deleteAssessmentType(Long id) {
        assessmentTypeRepository.deleteById(id);
    }
}
