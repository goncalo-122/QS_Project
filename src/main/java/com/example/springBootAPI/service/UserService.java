package com.example.springBootAPI.service;

import com.example.springBootAPI.entity.User;
import com.example.springBootAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @version 1.0
 * Service class for managing User entities.
 */

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Save a user.
     *
     * @param user the entity to save
     * @return the persisted entity
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Get all the users.
     *
     * @return the list of users
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Get one user by ID.
     *
     * @param id the ID of the user
     * @return user
     */
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Update a user.
     *
     * @param id the ID of the user
     * @param updatedUser the updated entity
     * @return the updated user
     */
    public User updateUser(Long id, User updatedUser) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setU_ut_id(updatedUser.getU_ut_id());
            user.setU_email(updatedUser.getU_email());
            user.setU_pass(updatedUser.getU_pass());
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    /**
     * Delete the user by ID.
     *
     * @param id the ID of the entity
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
