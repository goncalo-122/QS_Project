package com.example.springBootAPI.controller;

import com.example.springBootAPI.entity.Assessment;
import com.example.springBootAPI.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class AssessmentController {
    private final AssessmentService assessmentService;

    @Autowired
    public AssessmentController(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }

    /**
     * Create a new assessment.
     *
     * @param assessment the assessment to create
     * @return the ResponseEntity with status 200 (OK) and with body of the new assessment
     */
    @PostMapping("/assessments")
    public ResponseEntity<Assessment> saveAssessment(@RequestBody Assessment assessment) {
        Assessment newAssessment = assessmentService.saveAssessment(assessment);
        return ResponseEntity.ok(newAssessment);
    }

    /**
     * Get all assessments.
     *
     * @return the ResponseEntity with status 200 (OK) and with body of the list of assessments
     */
    @GetMapping("/assessments")
    public List<Assessment> getAllAssessments() {
        return assessmentService.getAllAssessments();
    }

    /**
     * Get assessment by ID.
     *
     * @param id the ID of the assessment to get
     * @return the ResponseEntity with status 200 (OK) and with body of the assessment, or with status 404 (Not Found) if the assessment does not exist
     */
    @GetMapping("/assessments/{id}")
    public ResponseEntity<Assessment> getAssessmentById(@PathVariable Long id) {
        Optional<Assessment> assessment = assessmentService.getAssessmentById(id);
        return assessment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Update assessment by ID.
     *
     * @param id the ID of the assessment to update
     * @param assessment the updated assessment
     * @return the ResponseEntity with status 200 (OK) and with body of the updated assessment, or with status 404 (Not Found) if the assessment does not exist
     */
    @PutMapping("/assessments/{id}")
    public ResponseEntity<Assessment> updateAssessment(@PathVariable Long id, @RequestBody Assessment assessment) {
        Assessment updatedAssessment = assessmentService.updateAssessment(id, assessment);
        return ResponseEntity.ok(updatedAssessment);
    }

    /**
     * Delete assessment by ID.
     *
     * @param id the ID of the assessment to delete
     * @return the ResponseEntity with status 200 (OK) and with body of the message "Assessments deleted successfully"
     */
    @DeleteMapping("/assessments/{id}")
    public ResponseEntity<String> deleteAssessment(@PathVariable Long id) {
        assessmentService.deleteAssessment(id);
        return ResponseEntity.ok("Assessment deleted successfully");
    }
}
