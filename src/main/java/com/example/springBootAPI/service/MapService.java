package com.example.springbootapi.service;

import com.example.springbootapi.entity.Map;
import com.example.springbootapi.repository.MapInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Map entities.
 */
@Service
public class MapService {

    private final MapInterface mapInterface;

    @Autowired
    public MapService(MapInterface mapInterface) {
        this.mapInterface = mapInterface;
    }

    /**
     * Save a map.
     *
     * @param map the entity to save
     * @return the persisted entity
     */
    public Map saveMap(Map map) {
        return mapInterface.save(map);
    }

    /**
     * Get all the maps.
     *
     * @return the list of maps
     */
    public List<Map> getAllMaps() {
        return mapInterface.findAll();
    }

    /**
     * Get one map by ID.
     *
     * @param id the ID of the map
     * @return map
     */
    public Optional<Map> getMapById(Long id) {
        return mapInterface.findById(id);
    }

    /**
     * Update a map.
     *
     * @param id the ID of the map
     * @param updatedMap the updated entity
     * @return the updated map
     */
    public Map updateMap(Long id, Map updatedMap) {
        Optional<Map> existingMap = mapInterface.findById(id);
        if (existingMap.isPresent()) {
            Map map = existingMap.get();

            map.setField1(updatedMap.getField1()); // Substitua `setField1` e `getField1` pelos métodos reais da entidade Map.
            map.setField2(updatedMap.getField2());
            // Adicione os setters necessários para cada campo que deseja atualizar.

            return mapInterface.save(map);
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
        mapInterface.deleteById(id);
    }
}
