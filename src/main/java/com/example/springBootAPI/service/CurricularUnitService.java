package com.example.springBootAPI.service;

import com.example.springBootAPI.entity.CurricularUnit;
import com.example.springBootAPI.entity.Degree;
import com.example.springBootAPI.repository.CurricularUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @version 1.0
 * Service class for managing CurricularUnit entities.
 */

@Service
public class CurricularUnitService {

    private final CurricularUnitRepository curricularUnitRepository;

    @Autowired
    public CurricularUnitService(CurricularUnitRepository curricularUnitRepository) {
        this.curricularUnitRepository = curricularUnitRepository;
    }

    /**
     * Save a curricular unit.
     *
     * @param curricularUnit the entity to save
     * @return the persisted entity
     */
    public CurricularUnit saveCurricularUnit(CurricularUnit curricularUnit) {
        return curricularUnitRepository.save(curricularUnit);
    }

    /**
     * Get all the curricular units.
     *
     * @return the list of entities
     */
    public List<CurricularUnit> getAllCurricularUnits() {
        return curricularUnitRepository.findAll();
    }

    /**
     * Get one curricular unit by ID.
     *
     * @param id the ID of the entity
     * @return the entity
     */
    public Optional<CurricularUnit> getCurricularUnitById(Long id) {
        return curricularUnitRepository.findById(id);
    }

    /**
     * Update a curricular unit.
     *
     * @param id the ID of the entity
     * @param updatedCurricularUnit the updated entity
     * @return the updated entity
     */
    public CurricularUnit updateCurricularUnit(Long id, CurricularUnit updatedCurricularUnit) {
        Optional<CurricularUnit> existingCurricularUnit = curricularUnitRepository.findById(id);
        if (existingCurricularUnit.isPresent()) {
            CurricularUnit curricularUnit = existingCurricularUnit.get();
            curricularUnit.setAssessments(updatedCurricularUnit.getAssessments());
            curricularUnit.setDegree(updatedCurricularUnit.getDegree());
            curricularUnit.setAssessmentType(updatedCurricularUnit.getAssessmentType());
            curricularUnit.setSemester(updatedCurricularUnit.getSemester());
            curricularUnit.setDescription(updatedCurricularUnit.getDescription());
            curricularUnit.setYear(updatedCurricularUnit.getYear());
            curricularUnit.setAttendance(updatedCurricularUnit.getAttendance());
            return curricularUnitRepository.save(curricularUnit);
        } else {
            throw new RuntimeException("Curricular unit not found");
        }
    }

    /**
     * Delete the curricular unit by ID.
     *
     * @param id the ID of the entity
     */
    public void deleteCurricularUnit(Long id) {
        curricularUnitRepository.deleteById(id);
    }
}
