package com.example.springbootapi.service;

import com.example.springbootapi.entity.Cu;
import com.example.springbootapi.repository.CuInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Cu entities.
 */
@Service
public class CuService {

    private final CuInterface cuInterface;

    @Autowired
    public CuService(CuInterface cuInterface) {
        this.cuInterface = cuInterface;
    }

    /**
     * Save a cu.
     *
     * @param cu the entity to save
     * @return the persisted entity
     */
    public Cu saveCu(Cu cu) {
        return cuInterface.save(cu);
    }

    /**
     * Get all the cus.
     *
     * @return the list of cus
     */
    public List<Cu> getAllCus() {
        return cuInterface.findAll();
    }

    /**
     * Get one cu by ID.
     *
     * @param id the ID of the cu
     * @return cu
     */
    public Optional<Cu> getCuById(Long id) {
        return cuInterface.findById(id);
    }

    /**
     * Update a cu.
     *
     * @param id the ID of the cu
     * @param updatedCu the updated entity
     * @return the updated cu
     */
    public Cu updateCu(Long id, Cu updatedCu) {
        Optional<Cu> existingCu = cuInterface.findById(id);
        if (existingCu.isPresent()) {
            Cu cu = existingCu.get();

            cu.setCu_id(updatedCu.getCu_id());
            cu.setCu_d_id(updatedCu.getCu_d_id());
            cu.setCu_at_id(updatedCu.getCu_at_id());
            cu.setCu_s_id(updatedCu.getCu_s_id());
            cu.setCu_dscr(updatedCu.getCu_dscr());
            cu.setCu_year(updatedCu.getCu_year());
            cu.setCu_attent(updatedCu.getCu_attent());

            return cuInterface.save(cu);
        } else {
            throw new RuntimeException("Cu not found");
        }
    }

    /**
     * Delete the cu by ID.
     *
     * @param id the ID of the entity
     */
    public void deleteCu(Long id) {
        cuInterface.deleteById(id);
    }
}
