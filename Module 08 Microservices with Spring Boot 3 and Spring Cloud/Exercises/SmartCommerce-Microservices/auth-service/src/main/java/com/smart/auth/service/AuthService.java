package com.smart.auth.service;

import com.smart.auth.dto.AuthRequest;
import com.smart.auth.model.AuthUser;
import com.smart.auth.repository.AuthRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthService {

    @Autowired
    private AuthRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(AuthRequest request) {

        if (repository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        if (request.getEmail() != null && repository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already in use");
        }

        AuthUser user = new AuthUser();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setRoles(resolveRoles(request));
        user.setActive(true);

        repository.save(user);
    }

    private Set<String> resolveRoles(AuthRequest request) {
        if (request.getUsername().startsWith("admin")) {
            return Set.of("ROLE_ADMIN");
        }
        return Set.of("ROLE_USER");
    }

    public AuthUser loadUser(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}