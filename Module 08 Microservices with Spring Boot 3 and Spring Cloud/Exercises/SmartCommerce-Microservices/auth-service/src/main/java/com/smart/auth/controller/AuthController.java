package com.smart.auth.controller;

import com.smart.auth.dto.AuthRequest;
import com.smart.auth.dto.AuthResponse;
import com.smart.auth.service.AuthService;
import com.smart.common.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        String token = jwtUtil.generateToken(authentication.getName());

        return ResponseEntity.ok(
                new AuthResponse(token, "Login successful")
        );
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest request) {

        authService.registerUser(request);

        String token = jwtUtil.generateToken(request.getUsername());

        return ResponseEntity.ok(
                new AuthResponse(token, "User registered successfully")
        );
    }

    @GetMapping("/validate")
    public ResponseEntity<Boolean> validate(@RequestParam String token) {
        return ResponseEntity.ok(jwtUtil.validateToken(token));
    }
}