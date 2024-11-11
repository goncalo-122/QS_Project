package com.example.springbootapi.controller;

import com.example.springbootapi.entity.Semester;
import com.example.springbootapi.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class SemesterController {

    private final SemesterService semesterService;

    @Autowired
    public SemesterController(SemesterService semesterService) {
        this.semesterService = semesterService;
    }
    /**
     * Create a new semester.
     *
     * @param semester to create
     * @return the ResponseEntity with status 200 (OK) and with body of the new period
     */
    @PostMapping("/semester")
    public ResponseEntity<Semester> saveSemester(@RequestBody Semester semester) {
        Semester newSemester = semesterService.saveSemester(semester);
        return ResponseEntity.ok(newSemester);
    }
    /**
     * Get all semesters.
     *
     * @return the ResponseEntity with status 200 (OK) and with body of the list of periods
     */
    @GetMapping("/semesters")
    public List<Semester> getAllSemesters() {
        return semesterService.getAllSemesters();
    }
    /**
     * Get a semester by ID.
     *
     * @param id the ID of the semester to get
     * @return the ResponseEntity with status 200 (OK) and with body of the period, or with status 404 (Not Found) if the map does not exist
     */
    @GetMapping("/semesters/{id}")
    public ResponseEntity<Semester> getSemesterById(@PathVariable Long id) {
        Optional<Semester> semester = semesterService.getSemesterById(id);
        return semester.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    /**
     * Update a semester by ID.
     *
     * @param id the ID of the semester to update
     * @param semester the updated semester
     * @return the ResponseEntity with status 200 (OK) and with body of the updated period, or with status 404 (Not Found) if the map does not exist
     */
    @PutMapping("/semesters/{id}")
    public ResponseEntity<Semester> updateSemester(@PathVariable Long id, @RequestBody Semester semester) {
        Semester updatedSemester = semesterService.updateSemester(id, semester);
        return ResponseEntity.ok(updatedSemester);
    }
    /**
     * Delete a semester by ID.
     *
     * @param id the ID of the semester to delete
     * @return the ResponseEntity with status 200 (OK) and with body of the message "Period deleted successfully"
     */
    @DeleteMapping("/semesters/{id}")
    public ResponseEntity<String> deleteSemester(@PathVariable Long id) {
        semesterService.deleteSemester(id);
        return ResponseEntity.ok("Semester deleted successfully");
    }
}
