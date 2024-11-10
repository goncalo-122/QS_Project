package com.example.springbootapi.repository;

import com.example.springbootapi.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for UserType entity.
 */
@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {
}