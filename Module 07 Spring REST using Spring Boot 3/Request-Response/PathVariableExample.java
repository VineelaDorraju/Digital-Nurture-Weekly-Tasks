package com.vineela.concepts.reqres;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class PathVariableExample {

    @GetMapping("/{userId}/orders/{orderId}")
    public Map<String, Object> getOrder(
            @PathVariable Long userId,
            @PathVariable Long orderId) {

        return Map.of(
                "userId", userId,
                "orderId", orderId,
                "message", "Fetched order for user"
        );
    }
}
