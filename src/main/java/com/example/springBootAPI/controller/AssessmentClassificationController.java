package com.example.springBootAPI.controller;

import com.example.springBootAPI.entity.AssessmentClassification;
import com.example.springBootAPI.service.AssessmentClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class AssessmentClassificationController {
    private final AssessmentClassificationService assessmentClassificationService;

    @Autowired
    public AssessmentClassificationController(AssessmentClassificationService assessmentClassificationService) {
        this.assessmentClassificationService = assessmentClassificationService;
    }

    /**
     * Create a new assessment classification.
     *
     * @param assessmentClassification the assessment classification to create
     * @return the ResponseEntity with status 200 (OK) and with body of the new assessment classification
     */
    @PostMapping("/assessmentClassifications")
    public ResponseEntity<AssessmentClassification> saveAssessmentClassification(@RequestBody AssessmentClassification assessmentClassification) {
        AssessmentClassification newAssessmentClassification = assessmentClassificationService.saveAssessmentClassification(assessmentClassification);
        return ResponseEntity.ok(newAssessmentClassification);
    }

    /**
     * Get all assessment classifications.
     *
     * @return the ResponseEntity with status 200 (OK) and with body of the list of assessment classifications
     */
    @GetMapping("/assessmentClassifications")
    public List<AssessmentClassification> getAllAssessmentClassifications() {
        return assessmentClassificationService.getAllAssessmentClassifications();
    }

    /**
     * Get assessment classification by ID.
     *
     * @param id the ID of the assessment classification to get
     * @return the ResponseEntity with status 200 (OK) and with body of the assessment classification, or with status 404 (Not Found) if the assessment classification does not exist
     */
    @GetMapping("/assessmentClassifications/{id}")
    public ResponseEntity<AssessmentClassification> getAssessmentClassificationById(@PathVariable Long id) {
        Optional<AssessmentClassification> assessmentClassification = assessmentClassificationService.getAssessmentClassificationById(id);
        return assessmentClassification.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Update assessment classification by ID.
     *
     * @param id the ID of the assessment classification to update
     * @param assessmentClassification the updated assessment classification
     * @return the ResponseEntity with status 200 (OK) and with body of the updated assessment classification, or with status 404 (Not Found) if the assessment classification does not exist
     */
    @PutMapping("/assessmentClassifications/{id}")
    public ResponseEntity<AssessmentClassification> updateAssessmentClassification(@PathVariable Long id, @RequestBody AssessmentClassification assessmentClassification) {
        AssessmentClassification updatedAssessmentClassification = assessmentClassificationService.updateAssessmentClassification(id, assessmentClassification);
        return ResponseEntity.ok(updatedAssessmentClassification);
    }

    /**
     * Delete assessment classification by ID.
     *
     * @param id the ID of the assessment classification to delete
     * @return the ResponseEntity with status 200 (OK) and with body of the message "assessment classification deleted successfully"
     */
    @DeleteMapping("/assessmentClassifications/{id}")
    public ResponseEntity<String> deleteAssessmentClassification(@PathVariable Long id) {
        assessmentClassificationService.deleteAssessmentClassification(id);
        return ResponseEntity.ok("Assessment classification deleted successfully");
    }
}
