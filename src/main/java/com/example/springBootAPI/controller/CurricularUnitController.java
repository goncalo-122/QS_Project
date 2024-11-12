package com.example.springBootAPI.controller;

import com.example.springBootAPI.entity.CurricularUnit;
import com.example.springBootAPI.service.CurricularUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CurricularUnitController {
    private final CurricularUnitService curricularUnitService;

    @Autowired
    public CurricularUnitController(CurricularUnitService curricularUnitService) {
        this.curricularUnitService = curricularUnitService;
    }

    /**
     * Create a new curricular unit.
     *
     * @param curricularUnit the curricular unit to create
     * @return the ResponseEntity with status 200 (OK) and with body of the new curricular unit
     */
    @PostMapping("/curricularUnits")
    public ResponseEntity<CurricularUnit> saveCurricularUnit(@RequestBody CurricularUnit curricularUnit) {
        CurricularUnit newCurricularUnit = curricularUnitService.saveCurricularUnit(curricularUnit);
        return ResponseEntity.ok(newCurricularUnit);
    }

    /**
     * Get all curricular unit.
     *
     * @return the ResponseEntity with status 200 (OK) and with body of the list of curricular units
     */
    @GetMapping("/curricularUnits")
    public List<CurricularUnit> getAllCurricularUnits() {
        return curricularUnitService.getAllCurricularUnits();
    }

    /**
     * Get a curricular unit by ID.
     *
     * @param id the ID of the curricular unit to get
     * @return the ResponseEntity with status 200 (OK) and with body of the curricular unit, or with status 404 (Not Found) if the curricular unit does not exist
     */
    @GetMapping("/curricularUnits/{id}")
    public ResponseEntity<CurricularUnit> getCurricularUnitById(@PathVariable Long id) {
        Optional<CurricularUnit> curricularUnit = curricularUnitService.getCurricularUnitById(id);
        return curricularUnit.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Update a curricular unit by ID.
     *
     * @param id the ID of the curricular unit to update
     * @param curricularUnit the updated curricularUnit
     * @return the ResponseEntity with status 200 (OK) and with body of the updated curricularUnit, or with status 404 (Not Found) if the curricularUnit does not exist
     */
    @PutMapping("/curricularUnits/{id}")
    public ResponseEntity<CurricularUnit> updateCurricularUnit(@PathVariable Long id, @RequestBody CurricularUnit curricularUnit) {
        CurricularUnit updatedCurricularUnit = curricularUnitService.updateCurricularUnit(id, curricularUnit);
        return ResponseEntity.ok(updatedCurricularUnit);
    }

    /**
     * Delete a curricular unit by ID.
     *
     * @param id the ID of the curricular unit to delete
     * @return the ResponseEntity with status 200 (OK) and with body of the message "Curricular unit deleted successfully"
     */
    @DeleteMapping("/curricularUnits/{id}")
    public ResponseEntity<String> deleteCurricularUnit(@PathVariable Long id) {
        curricularUnitService.deleteCurricularUnit(id);
        return ResponseEntity.ok("Curricular unit deleted successfully");
    }
}
