package com.example.springbootapi.service;

import com.example.springbootapi.entity.UserType;
import com.example.springbootapi.repository.UserTypeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing UserType entities.
 */
@Service
public class UserTypeService {

    private final UserTypeInterface userTypeInterface;

    @Autowired
    public UserTypeService(UserTypeInterface userTypeInterface) {
        this.userTypeInterface = userTypeInterface;
    }

    /**
     * Save a user type.
     *
     * @param userType the entity to save
     * @return the persisted entity
     */
    public UserType saveUserType(UserType userType) {
        return userTypeInterface.save(userType);
    }

    /**
     * Get all the user types.
     *
     * @return the list of user types
     */
    public List<UserType> getAllUserTypes() {
        return userTypeInterface.findAll();
    }

    /**
     * Get one user type by ID.
     *
     * @param id the ID of the user type
     * @return user type
     */
    public Optional<UserType> getUserTypeById(Long id) {
        return userTypeInterface.findById(id);
    }

    /**
     * Update a user type.
     *
     * @param id the ID of the user type
     * @param updatedUserType the updated entity
     * @return the updated user type
     */
    public UserType updateUserType(Long id, UserType updatedUserType) {
        Optional<UserType> existingUserType = userTypeInterface.findById(id);
        if (existingUserType.isPresent()) {
            UserType userType = existingUserType.get();

            userType.setName(updatedUserType.getName()); // Substitua `setName` pelo método real para atualizar os campos de UserType.
            // Adicione outros setters para os campos necessários.

            return userTypeInterface.save(userType);
        } else {
            throw new RuntimeException("UserType not found");
        }
    }

    /**
     * Delete the user type by ID.
     *
     * @param id the ID of the entity
     */
    public void deleteUserType(Long id) {
        userTypeInterface.deleteById(id);
    }
}
