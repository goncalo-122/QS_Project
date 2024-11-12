package com.example.springbootapi.controller;

import com.example.springBootAPI.entity.UserType;
import com.example.springBootAPI.service.UserTypeService;
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
     * Create a new user type.
     *
     * @param userType to create
     * @return the ResponseEntity with status 200 (OK) and with body of the new user type
     */
    @PostMapping("/userTypes")
    public ResponseEntity<UserType> saveUserType(@RequestBody UserType userType) {
        UserType newUserType = userTypeService.saveUserType(userType);
        return ResponseEntity.ok(newUserType);
    }
    /**
     * Get all user types.
     *
     * @return the ResponseEntity with status 200 (OK) and with body of the list of user types
     */
    @GetMapping("/userTypes")
    public List<UserType> getAllUserTypes() {
        return userTypeService.getAllUserTypes();
    }
    /**
     * Get a user type by ID.
     *
     * @param id the ID of the user type to get
     * @return the ResponseEntity with status 200 (OK) and with body of the user type, or with status 404 (Not Found) if the user type does not exist
     */
    @GetMapping("/userTypes/{id}")
    public ResponseEntity<UserType> getUserTypeById(@PathVariable Long id) {
        Optional<UserType> userType = userTypeService.getUserTypeById(id);
        return userType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    /**
     * Update a user type by ID.
     *
     * @param id the ID of the user type to update
     * @param userType the updated user type
     * @return the ResponseEntity with status 200 (OK) and with body of the updated user type, or with status 404 (Not Found) if the user type does not exist
     */
    @PutMapping("/userTypes/{id}")
    public ResponseEntity<UserType> updateUserType(@PathVariable Long id, @RequestBody UserType userType) {
        UserType updatedUserType = userTypeService.updateUserType(id, userType);
        return ResponseEntity.ok(updatedUserType);
    }
    /**
     * Delete a user type by ID.
     *
     * @param id the ID of the user type to delete
     * @return the ResponseEntity with status 200 (OK) and with body of the message "User type deleted successfully"
     */
    @DeleteMapping("/userTypes/{id}")
    public ResponseEntity<String> deleteUserType(@PathVariable Long id) {
        userTypeService.deleteUserType(id);
        return ResponseEntity.ok("User type deleted successfully");
    }
}
