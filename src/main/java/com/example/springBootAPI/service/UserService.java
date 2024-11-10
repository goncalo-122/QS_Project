package com.example.springbootapi.service;

import com.example.springbootapi.entity.User;
import com.example.springbootapi.repository.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing User entities.
 */
@Service
public class UserService {

    private final UserInterface userInterface;

    @Autowired
    public UserService(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    /**
     * Save a user.
     *
     * @param user the entity to save
     * @return the persisted entity
     */
    public User saveUser(User user) {
        return userInterface.save(user);
    }

    /**
     * Get all the users.
     *
     * @return the list of users
     */
    public List<User> getAllUsers() {
        return userInterface.findAll();
    }

    /**
     * Get one user by ID.
     *
     * @param id the ID of the user
     * @return user
     */
    public Optional<User> getUserById(Long id) {
        return userInterface.findById(id);
    }

    /**
     * Update a user.
     *
     * @param id the ID of the user
     * @param updatedUser the updated entity
     * @return the updated user
     */
    public User updateUser(Long id, User updatedUser) {
        Optional<User> existingUser = userInterface.findById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();

            user.setName(updatedUser.getName()); // Substitua `setName` pelo método real para atualizar os campos de User.
            user.setEmail(updatedUser.getEmail());
            // Adicione outros setters para os campos necessários.

            return userInterface.save(user);
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
        userInterface.deleteById(id);
    }
}
