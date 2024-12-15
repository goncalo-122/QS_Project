package com.example.springBootAPI.controller;

import com.example.springBootAPI.entity.User;
import com.example.springBootAPI.repository.UserRepository;
import com.example.springBootAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");

        // Fetch the user by email
        Optional<User> userOpt = userRepository.findByEmail(email);

        if (userOpt.isPresent()) {
            User user = userOpt.get();

            // Validate the password
            if (password.equals(user.getPassword())) {
                String userType = user.getType().getDescription();
                return ResponseEntity.ok(Map.of(
                        "message", "Login successful",
                        "userType", userType,
                        "userId", user.getId()
                ));
            }
        }

        // If login fails
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                "message", "Invalid email or password"
        ));
}

    /**
     * Create a new user.
     *
     * @param user to create
     * @return the ResponseEntity with status 200 (OK) and with body of the new user
     */
    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User newUser = userService.saveUser(user);
        return ResponseEntity.ok(newUser);
    }
    /**
     * Get all users.
     *
     * @return the ResponseEntity with status 200 (OK) and with body of the list of users
     */
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    /**
     * Get a user by ID.
     *
     * @param id the ID of the user to get
     * @return the ResponseEntity with status 200 (OK) and with body of the user, or with status 404 (Not Found) if the user does not exist
     */
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    /**
     * Update a user by ID.
     *
     * @param id the ID of the user to update
     * @param user the updated user
     * @return the ResponseEntity with status 200 (OK) and with body of the updated user, or with status 404 (Not Found) if the user does not exist
     */
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }
    /**
     * Delete a user by ID.
     *
     * @param id the ID of the user to delete
     * @return the ResponseEntity with status 200 (OK) and with body of the message "User deleted successfully"
     */
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
