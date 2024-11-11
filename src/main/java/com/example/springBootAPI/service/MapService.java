package com.example.springBootAPI.service;

import com.example.springBootAPI.entity.Map;
import com.example.springBootAPI.repository.MapRepository;
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

    private final MapRepository mapRepository;

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
            map.setM_s_id(updatedMap.getM_s_id());
            map.setM_p_id(updatedMap.getM_p_id());
            map.setM_d_id(updatedMap.getM_d_id());
            map.setM_u_id(updatedMap.getM_u_id());
            map.setM_lectiveyear(updatedMap.getM_lectiveyear());
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
