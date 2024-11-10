package com.example.springBootAPI.service;

import com.example.springBootAPI.entity.Degree;
import com.example.springBootAPI.repository.DegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Degree entities.
 */

@Service
public class DegreeService {

    private final DegreeRepository degreeRepository;

    @Autowired
    public DegreeService(DegreeRepository degreeRepository) {
        this.degreeRepository = degreeRepository;
    }

    /**
     * Save a degree.
     *
     * @param degree the entity to save
     * @return the persisted entity
     */
    public Degree saveDegree(Degree degree) {
        return degreeRepository.save(degree);
    }

    /**
     * Get all the degrees.
     *
     * @return the list of degrees
     */
    public List<Degree> getAllDegrees() {
        return degreeRepository.findAll();
    }

    /**
     * Get one degree by ID.
     *
     * @param id the ID of the entity
     * @return the entity
     */
    public Optional<Degree> getDegreeById(Long id) {
        return degreeRepository.findById(id);
    }

    /**
     * Update a degree.
     *
     * @param id the ID of the entity
     * @param updatedDegree the updated entity
     * @return the updated entity
     */
    public Degree updateDegree(Long id, Degree updatedDegree) {
        Optional<Degree> existingDegree = degreeRepository.findById(id);
        if (existingDegree.isPresent()) {
            Degree degree = existingDegree.get();
            degree.setDscr(updatedDegree.getDscr());
            return degreeRepository.save(degree);
        } else {
            throw new RuntimeException("Degree not found");
        }
    }

    /**
     * Delete the degree by ID.
     *
     * @param id the ID of the entity
     */
    public void deleteDegree(Long id) {
        degreeRepository.deleteById(id);
    }
}
