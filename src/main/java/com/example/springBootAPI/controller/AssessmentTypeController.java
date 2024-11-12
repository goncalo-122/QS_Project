package com.example.springBootAPI.controller;

import com.example.springBootAPI.entity.AssessmentType;
import com.example.springBootAPI.service.AssessmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class AssessmentTypeController {
    private final AssessmentTypeService assessmentTypeService;

    @Autowired
    public AssessmentTypeController(AssessmentTypeService assessmentTypeService) {
        this.assessmentTypeService = assessmentTypeService;
    }

    /**
     * Create a new assessment type.
     *
     * @param assessmentType the assessment type to create
     * @return the ResponseEntity with status 200 (OK) and with body of the new assessment type
     */
    @PostMapping("/assessmentTypes")
    public ResponseEntity<AssessmentType> saveAssessmentType(@RequestBody AssessmentType assessmentType) {
        AssessmentType newAssessmentType = assessmentTypeService.saveAssessmentType(assessmentType);
        return ResponseEntity.ok(newAssessmentType);
    }

    /**
     * Get all assessment types.
     *
     * @return the ResponseEntity with status 200 (OK) and with body of the list of assessment types
     */
    @GetMapping("/assessmentTypes")
    public List<AssessmentType> getAllAssessmentTypes() {
        return assessmentTypeService.getAllAssessmentTypes();
    }

    /**
     * Get assessment type by ID.
     *
     * @param id the ID of the assessment type to get
     * @return the ResponseEntity with status 200 (OK) and with body of the assessment type, or with status 404 (Not Found) if the assessment type does not exist
     */
    @GetMapping("/assessmentTypes/{id}")
    public ResponseEntity<AssessmentType> getAssessmentTypeById(@PathVariable Long id) {
        Optional<AssessmentType> assessmentType = assessmentTypeService.getAssessmentTypeById(id);
        return assessmentType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    /**
     * Update assessment type by ID.
     *
     * @param id the ID of the assessment type to update
     * @param assessmentType the updated assessment type
     * @return the ResponseEntity with status 200 (OK) and with body of the updated assessment type, or with status 404 (Not Found) if the assessment type does not exist
     */
    @PutMapping("/assessmentTypes/{id}")
    public ResponseEntity<AssessmentType> updateAssessmentType(@PathVariable Long id, @RequestBody AssessmentType assessmentType) {
        AssessmentType updatedAssessmentType = assessmentTypeService.updateAssessmentType(id, assessmentType);
        return ResponseEntity.ok(updatedAssessmentType);
    }

    /**
     * Delete assessment type by ID.
     *
     * @param id the ID of the assessment type to delete
     * @return the ResponseEntity with status 200 (OK) and with body of the message "Assessment type deleted successfully"
     */
    @DeleteMapping("/assessmentTypes/{id}")
    public ResponseEntity<String> deleteAssessmentType(@PathVariable Long id) {
        assessmentTypeService.deleteAssessmentType(id);
        return ResponseEntity.ok("Assessment type deleted successfully");
    }
}
