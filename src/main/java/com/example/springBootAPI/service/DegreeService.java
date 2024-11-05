package com.example.springBootAPI.service;

import com.example.springBootAPI.entities.Degree;
import com.example.springBootAPI.repository.DegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

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
    public Degree saveProduct(Degree degree) {
        return degreeRepository.save(degree);
    }

    /**
     * Get all the degrees.
     *
     * @return the list of degrees
     */
    public List<Degree> getAllProducts() {
        return degreeRepository.findAll();
    }

    /**
     * Get one degree by ID.
     *
     * @param id the ID of the entity
     * @return the entity
     */
    public Optional<Degree> getProductById(Long id) {
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
            throw new RuntimeException("Product not found");
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
