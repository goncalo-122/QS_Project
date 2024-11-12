package com.example.springBootAPI.controller;

import com.example.springBootAPI.entity.Period;
import com.example.springBootAPI.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PeriodController {
    private final PeriodService periodService;

    @Autowired
    public PeriodController(PeriodService periodService) {
        this.periodService = periodService;
    }

    /**
     * Create a new period.
     *
     * @param period to create
     * @return the ResponseEntity with status 200 (OK) and with body of the new period
     */
    @PostMapping("/periods")
    public ResponseEntity<Period> savePeriod(@RequestBody Period period) {
        Period newPeriod = periodService.savePeriod(period);
        return ResponseEntity.ok(newPeriod);
    }

    /**
     * Get all periods.
     *
     * @return the ResponseEntity with status 200 (OK) and with body of the list of periods
     */
    @GetMapping("/periods")
    public List<Period> getAllPeriods() {
        return periodService.getAllPeriods();
    }

    /**
     * Get a period by ID.
     *
     * @param id the ID of the period to get
     * @return the ResponseEntity with status 200 (OK) and with body of the period, or with status 404 (Not Found) if the map does not exist
     */
    @GetMapping("/periods/{id}")
    public ResponseEntity<Period> getPeriodById(@PathVariable Long id) {
        Optional<Period> period = periodService.getPeriodById(id);
        return period.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Update a period by ID.
     *
     * @param id the ID of the period to update
     * @param period the updated period
     * @return the ResponseEntity with status 200 (OK) and with body of the updated period, or with status 404 (Not Found) if the map does not exist
     */
    @PutMapping("/periods/{id}")
    public ResponseEntity<Period> updatePeriod(@PathVariable Long id, @RequestBody Period period) {
        Period updatedPeriod = periodService.updatePeriod(id, period);
        return ResponseEntity.ok(updatedPeriod);
    }

    /**
     * Delete a period by ID.
     *
     * @param id the ID of the period to delete
     * @return the ResponseEntity with status 200 (OK) and with body of the message "Period deleted successfully"
     */
    @DeleteMapping("/periods/{id}")
    public ResponseEntity<String> deletePeriod(@PathVariable Long id) {
        periodService.deletePeriod(id);
        return ResponseEntity.ok("Period deleted successfully");
    }
}
