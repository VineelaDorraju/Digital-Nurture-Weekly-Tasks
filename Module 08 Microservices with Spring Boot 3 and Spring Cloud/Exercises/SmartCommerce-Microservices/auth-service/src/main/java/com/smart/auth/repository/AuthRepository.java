package com.smart.auth.repository;

import com.smart.auth.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface AuthRepository extends JpaRepository<AuthUser, Long> {

    Optional<AuthUser> findByUsername(String username);
    Optional<AuthUser> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    List<AuthUser> findByActiveTrue();
    List<AuthUser> findByRolesContaining(String role);
}