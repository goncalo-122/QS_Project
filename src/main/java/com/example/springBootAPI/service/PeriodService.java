package com.example.springBootAPI.service;

import com.example.springBootAPI.entity.Period;
import com.example.springBootAPI.repository.PeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @version 1.0
 * Service class for managing Period entities.
 */

@Service
public class PeriodService {
    private final PeriodRepository periodRepository;

    @Autowired
    public PeriodService(PeriodRepository periodRepository) {
        this.periodRepository = periodRepository;
    }

    /**
     * Save a period.
     *
     * @param period the entity to save
     * @return the persisted entity
     */
    public Period savePeriod(Period period) {
        return periodRepository.save(period);
    }

    /**
     * Get all the period.
     *
     * @return the list of entities
     */
    public List<Period> getAllPeriod() {
        return periodRepository.findAll();
    }

    /**
     * Get one period by ID.
     *
     * @param id the ID of the entity
     * @return the entity
     */
    public Optional<Period> getPeriodById(Long id) {
        return periodRepository.findById(id);
    }

    /**
     * Update a period.
     *
     * @param id the ID of the entity
     * @param updatedPeriod the updated entity
     * @return the updated entity
     */
    public Period updatePeriod(Long id, Period updatedPeriod) {
        Optional<Period> existingPeriod = periodRepository.findById(id);
        if (existingPeriod.isPresent()) {
            Period period = existingPeriod.get();
            period.setP_dscr(updatedPeriod.getP_dscr());
            period.setP_initdate(updatedPeriod.getP_initdate());
            period.setP_enddate(updatedPeriod.getP_enddate());
            return periodRepository.save(period);
        } else {
            throw new RuntimeException("Period not found");
        }
    }

    /**
     * Delete the period by ID.
     *
     * @param id the ID of the entity
     */
    public void deletePeriod(Long id) {
        periodRepository.deleteById(id);
    }
}
