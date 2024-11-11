package com.example.springBootAPI.repository;

import com.example.springBootAPI.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for UserType entity.
 */

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {
}
