package com.example.springBootAPI.controller;

import com.example.springBootAPI.entity.Degree;
import com.example.springBootAPI.service.DegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class DegreeController {
    private final DegreeService degreeService;

    @Autowired
    public DegreeController(DegreeService degreeService) {
        this.degreeService = degreeService;
    }

    /**
     * Create a new degree.
     *
     * @param degree the degree to create
     * @return the ResponseEntity with status 200 (OK) and with body of the new degree
     */
    @PostMapping("/degrees")
    public ResponseEntity<Degree> saveDegree(@RequestBody Degree degree) {
        Degree newDegree = degreeService.saveDegree(degree);
        return ResponseEntity.ok(newDegree);
    }

    /**
     * Get all degrees.
     *
     * @return the ResponseEntity with status 200 (OK) and with body of the list of degrees
     */
    @GetMapping("/degrees")
    public List<Degree> getAllDegrees() {
        return degreeService.getAllDegrees();
    }

    /**
     * Get a degree by ID.
     *
     * @param id the ID of the degree to get
     * @return the ResponseEntity with status 200 (OK) and with body of the degree, or with status 404 (Not Found) if the degree does not exist
     */
    @GetMapping("/degrees/{id}")
    public ResponseEntity<Degree> getDegreeById(@PathVariable Long id) {
        Optional<Degree> degree = degreeService.getDegreeById(id);
        return degree.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Update a degree by ID.
     *
     * @param id the ID of the degree to update
     * @param degree the updated degree
     * @return the ResponseEntity with status 200 (OK) and with body of the updated degree, or with status 404 (Not Found) if the degree does not exist
     */
    @PutMapping("/degrees/{id}")
    public ResponseEntity<Degree> updateDegree(@PathVariable Long id, @RequestBody Degree degree) {
        Degree updatedDegree = degreeService.updateDegree(id, degree);
        return ResponseEntity.ok(updatedDegree);
    }

    /**
     * Delete a degree by ID.
     *
     * @param id the ID of the degree to delete
     * @return the ResponseEntity with status 200 (OK) and with body of the message "Degree deleted successfully"
     */
    @DeleteMapping("/degrees/{id}")
    public ResponseEntity<String> deleteDegree(@PathVariable Long id) {
        degreeService.deleteDegree(id);
        return ResponseEntity.ok("Degree deleted successfully");
    }
}
