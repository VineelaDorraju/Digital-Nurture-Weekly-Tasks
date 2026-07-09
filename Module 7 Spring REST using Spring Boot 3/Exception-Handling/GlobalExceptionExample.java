package com.vineela.concepts.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/exception-demo")
public class GlobalExceptionExample {

    static class NotFoundException extends RuntimeException {
        NotFoundException(String m){ super(m); }
    }

    @GetMapping("/{id}")
    public Map<String,Object> get(@PathVariable int id){
        if (id != 1) throw new NotFoundException("Resource not found: " + id);
        return Map.of("id", id, "value", "OK");
    }

    @ControllerAdvice
    static class GlobalHandler {

        @ExceptionHandler(NotFoundException.class)
        public ResponseEntity<?> handleNotFound(NotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                    "timestamp", Instant.now().toString(),
                    "error", "NOT_FOUND",
                    "message", ex.getMessage()
            ));
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<?> handleAny(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "timestamp", Instant.now().toString(),
                    "error", "INTERNAL_ERROR",
                    "message", ex.getMessage()
            ));
        }
    }
}
