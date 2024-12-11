package com.example.springBootAPI.service;

import com.example.springBootAPI.entity.Degree;
import com.example.springBootAPI.entity.Map;
import com.example.springBootAPI.entity.Period;
import com.example.springBootAPI.entity.Semester;
import com.example.springBootAPI.repository.DegreeRepository;
import com.example.springBootAPI.repository.MapRepository;
import com.example.springBootAPI.repository.PeriodRepository;
import com.example.springBootAPI.repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @version 1.0
 * Service class for managing Map entities.
 */

@Service
public class MapService {

    @Autowired
    private PeriodRepository periodRepository;
    @Autowired
    private SemesterRepository semesterRepository;
    @Autowired
    private DegreeRepository degreeRepository;
    @Autowired
    private MapRepository mapRepository;

    @Autowired
    public MapService(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    /**
     * Save a map.
     *
     * @param map the entity to save
     * @return the persisted entity
     */
    public Map saveMap(Map map) {
        // Fetch and set the managed Period entity
        Period period = periodRepository.findById(map.getPeriod().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Period ID"));
        map.setPeriod(period);

        // Fetch and set the managed Semester entity
        Semester semester = semesterRepository.findById(map.getSemester().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Semester ID"));
        map.setSemester(semester);

        // Fetch and set the managed Degree entity
        Degree degree = degreeRepository.findById(map.getDegree().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Degree ID"));
        map.setDegree(degree);
        degree.addMap(map);

        // Save the Map entity
        return mapRepository.save(map);
    }

    /**
     * Get all the maps.
     *
     * @return the list of entities
     */
    public List<Map> getAllMaps() {
        return mapRepository.findAll();
    }

    /**
     * Get one map by ID.
     *
     * @param id the ID of the entity
     * @return the entity
     */
    public Optional<Map> getMapById(Long id) {
        return mapRepository.findById(id);
    }

    /**
     * Update a map.
     *
     * @param id the ID of the entity
     * @param updatedMap the updated entity
     * @return the updated entity
     */
    public Map updateMap(Long id, Map updatedMap) {
        Optional<Map> existingMap = mapRepository.findById(id);
        if (existingMap.isPresent()) {
            Map map = existingMap.get();
            map.setCurricularUnits(updatedMap.getCurricularUnits());
            map.setSemester(updatedMap.getSemester());
            map.setPeriod(updatedMap.getPeriod());
            map.setDegree(updatedMap.getDegree());
//            map.setUser(updatedMap.getUser());
            map.setLectiveyear(updatedMap.getLectiveyear());
            return mapRepository.save(map);
        } else {
            throw new RuntimeException("Map not found");
        }
    }

    /**
     * Delete the map by ID.
     *
     * @param id the ID of the entity
     */
    public void deleteMap(Long id) {
        mapRepository.deleteById(id);
    }
}
