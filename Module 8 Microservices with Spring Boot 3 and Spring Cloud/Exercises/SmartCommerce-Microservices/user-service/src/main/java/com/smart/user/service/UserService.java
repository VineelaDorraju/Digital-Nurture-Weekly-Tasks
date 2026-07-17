package com.smart.user.service;

import com.smart.user.dto.UserDTO;
import com.smart.user.entity.User;
import com.smart.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserDTO createUser(UserDTO dto) {

        if (repository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already registered.");
        }

        User user = mapToEntity(dto);

        return mapToDTO(repository.save(user));
    }

    public UserDTO getUser(String userId) {

        User user = repository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found."));

        return mapToDTO(user);
    }

    public List<UserDTO> getAllUsers() {

        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO updateUser(String userId, UserDTO dto) {

        User user = repository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found."));

        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        user.setActive(dto.isActive());

        return mapToDTO(repository.save(user));
    }

    public void deleteUser(String userId) {

        User user = repository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found."));

        repository.delete(user);
    }

    public List<UserDTO> getActiveUsers() {

        return repository.findByActiveTrue()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private UserDTO mapToDTO(User user) {

        UserDTO dto = new UserDTO();

        dto.setUserId(user.getUserId());
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        dto.setActive(user.isActive());

        return dto;
    }

    private User mapToEntity(UserDTO dto) {

        User user = new User();

        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        user.setActive(dto.isActive());

        return user;
    }
}