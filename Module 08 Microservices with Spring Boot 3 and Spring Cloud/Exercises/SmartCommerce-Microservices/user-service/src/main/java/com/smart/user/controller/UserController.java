package com.smart.user.controller;

import com.smart.common.response.ApiResponse;
import com.smart.user.dto.UserDTO;
import com.smart.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ApiResponse<UserDTO> createUser(@RequestBody UserDTO user) {
        return ApiResponse.success(
                service.createUser(user),
                "User created successfully"
        );
    }

    @GetMapping("/{userId}")
    public ApiResponse<UserDTO> getUser(@PathVariable String userId) {
        return ApiResponse.success(
                service.getUser(userId),
                "User retrieved successfully"
        );
    }

    @GetMapping
    public ApiResponse<List<UserDTO>> getAllUsers() {
        return ApiResponse.success(
                service.getAllUsers(),
                "Users fetched successfully"
        );
    }

    @PutMapping("/{userId}")
    public ApiResponse<UserDTO> updateUser(
            @PathVariable String userId,
            @RequestBody UserDTO user) {

        return ApiResponse.success(
                service.updateUser(userId, user),
                "User updated successfully"
        );
    }

    @DeleteMapping("/{userId}")
    public ApiResponse<String> deleteUser(@PathVariable String userId) {

        service.deleteUser(userId);

        return ApiResponse.success(
                "DELETED",
                "User deleted successfully"
        );
    }

    @GetMapping("/active")
    public ApiResponse<List<UserDTO>> getActiveUsers() {
        return ApiResponse.success(
                service.getActiveUsers(),
                "Active users fetched"
        );
    }
}