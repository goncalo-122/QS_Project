package com.example.springBootAPI.service;

import com.example.springBootAPI.entity.Semester;
import com.example.springBootAPI.repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @version 1.0
 * Service class for managing Semester entities.
 */

@Service
public class SemesterService {
    private final SemesterRepository semesterRepository;

    @Autowired
    public SemesterService(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }

    /**
     * Save a semester.
     *
     * @param semester the entity to save
     * @return the persisted entity
     */
    public Semester saveSemester(Semester semester) {
        return semesterRepository.save(semester);
    }

    /**
     * Get all the semesters.
     *
     * @return the list of entities
     */
    public List<Semester> getAllSemesters() {
        return semesterRepository.findAll();
    }

    /**
     * Get one semester by ID.
     *
     * @param id the ID of the entity
     * @return the entity
     */
    public Optional<Semester> getSemesterById(Long id) {
        return semesterRepository.findById(id);
    }

    /**
     * Update a semester.
     *
     * @param id the ID of the entity
     * @param updatedSemester the updated entity
     * @return the updated entity
     */
    public Semester updateSemester(Long id, Semester updatedSemester) {
        Optional<Semester> existingSemester = semesterRepository.findById(id);
        if (existingSemester.isPresent()) {
            Semester semester = existingSemester.get();
            semester.setS_dscr(updatedSemester.getS_dscr());
            semester.setS_initdate(updatedSemester.getS_initdate());
            semester.setS_enddate(updatedSemester.getS_enddate());
            return semesterRepository.save(semester);
        } else {
            throw new RuntimeException("Semester not found");
        }
    }

    /**
     * Delete the semester by ID.
     *
     * @param id the ID of the entity
     */
    public void deleteSemester(Long id) {
        semesterRepository.deleteById(id);
    }
}
