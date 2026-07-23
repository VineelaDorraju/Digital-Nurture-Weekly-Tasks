package com.vineela.concepts.reqres;

import jakarta.validation.constraints.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/register")
@Validated
public class RequestBodyExample {

    static class RegisterRequest {
        @NotBlank public String name;
        @Email public String email;
        @Size(min = 6, max = 20) public String password;
        @Min(18) public int age;
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Validated RegisterRequest req) {
        return ResponseEntity.ok(Map.of(
                "message", "User registered",
                "user", Map.of("name", req.name, "email", req.email, "age", req.age)
        ));
    }
}
