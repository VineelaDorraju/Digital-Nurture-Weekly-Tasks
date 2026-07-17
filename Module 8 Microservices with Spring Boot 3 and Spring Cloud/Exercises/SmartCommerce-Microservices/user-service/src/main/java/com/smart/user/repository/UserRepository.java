package com.smart.user.repository;

import com.smart.user.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByEmail(String email);

    List<User> findByRole(String role);

    List<User> findByActiveTrue();

    List<User> findByFullNameContainingIgnoreCase(String keyword);

    boolean existsByEmail(String email);

    long countByRole(String role);
}