package com.example.springBootAPI.controller;

import com.example.springBootAPI.entity.Semester;
import com.example.springBootAPI.service.SemesterService;
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
     * @return the ResponseEntity with status 200 (OK) and with body of the new semester
     */
    @PostMapping("/semesters")
    public ResponseEntity<Semester> saveSemester(@RequestBody Semester semester) {
        Semester newSemester = semesterService.saveSemester(semester);
        return ResponseEntity.ok(newSemester);
    }
    /**
     * Get all semesters.
     *
     * @return the ResponseEntity with status 200 (OK) and with body of the list of semesters
     */
    @GetMapping("/semesters")
    public List<Semester> getAllSemesters() {
        return semesterService.getAllSemesters();
    }
    /**
     * Get a semester by ID.
     *
     * @param id the ID of the semester to get
     * @return the ResponseEntity with status 200 (OK) and with body of the semester, or with status 404 (Not Found) if the semester does not exist
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
     * @return the ResponseEntity with status 200 (OK) and with body of the updated semester, or with status 404 (Not Found) if the semester does not exist
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
     * @return the ResponseEntity with status 200 (OK) and with body of the message "Semester deleted successfully"
     */
    @DeleteMapping("/semesters/{id}")
    public ResponseEntity<String> deleteSemester(@PathVariable Long id) {
        semesterService.deleteSemester(id);
        return ResponseEntity.ok("Semester deleted successfully");
    }
}
