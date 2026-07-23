package com.smart.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {
        return builder.routes()

                .route("auth-service", r -> r
                        .path("/auth/**")
                        .filters(f -> f
                                .stripPrefix(1)
                                .addRequestHeader("X-Gateway", "Auth-Service")
                        )
                        .uri("lb://AUTH-SERVICE")
                )

                .route("user-service", r -> r
                        .path("/users/**")
                        .filters(f -> f
                                .stripPrefix(1)
                                .addResponseHeader("X-Response-Time", String.valueOf(System.currentTimeMillis()))
                        )
                        .uri("lb://USER-SERVICE")
                )

                .route("product-service", r -> r
                        .path("/products/**")
                        .filters(f -> f
                                .stripPrefix(1)
                                .rewritePath("/products/(?<segment>.*)", "/${segment}")
                        )
                        .uri("lb://PRODUCT-SERVICE")
                )

                .route("order-service", r -> r
                        .path("/orders/**")
                        .filters(f -> f
                                .stripPrefix(1)
                                .retry(2)
                        )
                        .uri("lb://ORDER-SERVICE")
                )

                .route("payment-service", r -> r
                        .path("/payments/**")
                        .filters(f -> f
                                .stripPrefix(1)
                                .circuitBreaker(c -> c
                                        .setName("paymentCB")
                                        .setFallbackUri("forward:/fallback/payment")
                                )
                        )
                        .uri("lb://PAYMENT-SERVICE")
                )

                .route("inventory-service", r -> r
                        .path("/inventory/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://INVENTORY-SERVICE")
                )

                .route("notification-service", r -> r
                        .path("/notify/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://NOTIFICATION-SERVICE")
                )

                .build();
    }
}