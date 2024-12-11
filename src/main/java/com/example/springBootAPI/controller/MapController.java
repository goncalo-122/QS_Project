package com.example.springBootAPI.controller;

import com.example.springBootAPI.entity.Map;
import com.example.springBootAPI.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class MapController {
    private final MapService mapService;

    @Autowired
    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    /**
     * Create a new map.
     *
     * @param map to create
     * @return the ResponseEntity with status 200 (OK) and with body of the new map
     */
    @PostMapping("/maps")
    public ResponseEntity<Map> saveMap(@RequestBody Map map) {
        Map newMap = mapService.saveMap(map);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMap);
    }

    /**
     * Get all maps.
     *
     * @return the ResponseEntity with status 200 (OK) and with body of the list of maps
     */
    @GetMapping("/maps")
    public List<Map> getAllMaps() {
        return mapService.getAllMaps();
    }

    /**
     * Get a map by ID.
     *
     * @param id the ID of the map to get
     * @return the ResponseEntity with status 200 (OK) and with body of the map, or with status 404 (Not Found) if the map does not exist
     */
    @GetMapping("/maps/{id}")
    public ResponseEntity<Map> getMapById(@PathVariable Long id) {
        Optional<Map> map = mapService.getMapById(id);
        return map.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Update a map by ID.
     *
     * @param id the ID of the map to update
     * @param map the updated map
     * @return the ResponseEntity with status 200 (OK) and with body of the updated map, or with status 404 (Not Found) if the map does not exist
     */
    @PutMapping("/maps/{id}")
    public ResponseEntity<Map> updateMap(@PathVariable Long id, @RequestBody Map map) {
        Map updatedMap = mapService.updateMap(id, map);
        return ResponseEntity.ok(updatedMap);
    }

    /**
     * Delete a map by ID.
     *
     * @param id the ID of the map to delete
     * @return the ResponseEntity with status 200 (OK) and with body of the message "Map deleted successfully"
     */
    @DeleteMapping("/maps/{id}")
    public ResponseEntity<String> deleteMap(@PathVariable Long id) {
        mapService.deleteMap(id);
        return ResponseEntity.ok("Map deleted successfully");
    }
}
