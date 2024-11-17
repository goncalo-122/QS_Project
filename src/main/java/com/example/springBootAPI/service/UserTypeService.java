package com.example.springBootAPI.service;

import com.example.springBootAPI.entity.UserType;
import com.example.springBootAPI.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @version 1.0
 * Service class for managing UserType entities.
 */

@Service
public class UserTypeService {
    private final UserTypeRepository userTypeRepository;

    @Autowired
    public UserTypeService(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    /**
     * Save a user type.
     *
     * @param userType the entity to save
     * @return the persisted entity
     */
    public UserType saveUserType(UserType userType) {
        return userTypeRepository.save(userType);
    }

    /**
     * Get all the user types.
     *
     * @return the list of user types
     */
    public List<UserType> getAllUserTypes() {
        return userTypeRepository.findAll();
    }

    /**
     * Get one user type by ID.
     *
     * @param id the ID of the user type
     * @return user type
     */
    public Optional<UserType> getUserTypeById(Long id) {
        return userTypeRepository.findById(id);
    }

    /**
     * Update a user type.
     *
     * @param id the ID of the user type
     * @param updatedUserType the updated entity
     * @return the updated user type
     */
    public UserType updateUserType(Long id, UserType updatedUserType) {
        Optional<UserType> existingUserType = userTypeRepository.findById(id);
        if (existingUserType.isPresent()) {
            UserType userType = existingUserType.get();
            userType.setDescription(updatedUserType.getDescription());
            return userTypeRepository.save(userType);
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
        userTypeRepository.deleteById(id);
    }
}
