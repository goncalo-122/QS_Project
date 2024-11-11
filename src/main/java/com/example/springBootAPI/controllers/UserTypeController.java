package com.example.springbootapi.controller;

import com.example.springbootapi.entity.UserType;
import com.example.springbootapi.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserTypeController {

    private final UserTypeService userTypeService;

    @Autowired
    public UserTypeController(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }
    /**
     * Create a new userType.
     *
     * @param userType to create
     * @return the ResponseEntity with status 200 (OK) and with body of the new period
     */
    @PostMapping("/userType")
    public ResponseEntity<UserType> saveUserType(@RequestBody UserType userType) {
        UserType newUserType = userTypeService.saveUserType(userType);
        return ResponseEntity.ok(newUserType);
    }
    /**
     * Get all userTypes.
     *
     * @return the ResponseEntity with status 200 (OK) and with body of the list of periods
     */
    @GetMapping("/userTypes")
    public List<UserType> getAllUserTypes() {
        return userTypeService.getAllUserTypes();
    }
    /**
     * Get a userType by ID.
     *
     * @param id the ID of the userType to get
     * @return the ResponseEntity with status 200 (OK) and with body of the period, or with status 404 (Not Found) if the map does not exist
     */
    @GetMapping("/userTypes/{id}")
    public ResponseEntity<UserType> getUserTypeById(@PathVariable Long id) {
        Optional<UserType> userType = userTypeService.getUserTypeById(id);
        return userType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    /**
     * Update a period by ID.
     *
     * @param id the ID of the userType to update
     * @param userType the updated userType
     * @return the ResponseEntity with status 200 (OK) and with body of the updated period, or with status 404 (Not Found) if the map does not exist
     */
    @PutMapping("/userTypes/{id}")
    public ResponseEntity<UserType> updateUserType(@PathVariable Long id, @RequestBody UserType userType) {
        UserType updatedUserType = userTypeService.updateUserType(id, userType);
        return ResponseEntity.ok(updatedUserType);
    }
    /**
     * Delete a userType by ID.
     *
     * @param id the ID of the userType to delete
     * @return the ResponseEntity with status 200 (OK) and with body of the message "Period deleted successfully"
     */
    @DeleteMapping("/userTypes/{id}")
    public ResponseEntity<String> deleteUserType(@PathVariable Long id) {
        userTypeService.deleteUserType(id);
        return ResponseEntity.ok("UserType deleted successfully");
    }
}
