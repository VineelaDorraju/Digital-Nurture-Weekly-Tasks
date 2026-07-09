package com.vineela.concepts.controllers;

import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/system")
public class SimpleController {

    @GetMapping("/ping")
    public Map<String, Object> ping() {
        return Map.of("status", "UP", "time", Instant.now().toString());
    }

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name,
                        @RequestParam(defaultValue = "en") String lang) {
        return switch (lang) {
            case "hi" -> "Namaste " + name;
            case "te" -> "Namaskaram " + name;
            default -> "Hello " + name;
        };
    }
}
