package com.smart.user.dto;

import java.time.LocalDateTime;
import java.util.Set;

public class UserDTO {

    private String userId;
    private String username;
    private String email;
    private Set<String> roles;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime lastLogin;

    public UserDTO() {
        this.active = true;
        this.createdAt = LocalDateTime.now();
    }

    public UserDTO(String userId, String username, String email, Set<String> roles) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.active = true;
        this.createdAt = LocalDateTime.now();
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public boolean isActive() {
        return active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }
}