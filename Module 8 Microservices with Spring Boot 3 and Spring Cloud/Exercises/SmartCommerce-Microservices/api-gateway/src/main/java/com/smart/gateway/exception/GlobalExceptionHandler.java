package com.smart.gateway.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler implements WebExceptionHandler {

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {

        HttpStatus status = resolveStatus(ex);
        String body = buildResponse(status, ex.getMessage(), exchange);

        byte[] bytes = body.getBytes(StandardCharsets.UTF_8);

        exchange.getResponse().setStatusCode(status);
        exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);

        return exchange.getResponse()
                .writeWith(Mono.just(exchange.getResponse()
                        .bufferFactory()
                        .wrap(bytes)));
    }

    private HttpStatus resolveStatus(Throwable ex) {
        String message = ex.getMessage() == null ? "" : ex.getMessage().toLowerCase();

        if (message.contains("not found")) return HttpStatus.NOT_FOUND;
        if (message.contains("timeout")) return HttpStatus.GATEWAY_TIMEOUT;
        if (message.contains("unauthorized") || message.contains("forbidden")) return HttpStatus.UNAUTHORIZED;

        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    private String buildResponse(HttpStatus status, String message, ServerWebExchange exchange) {

        String path = exchange.getRequest().getURI().getPath();

        return "{"
                + "\"timestamp\":\"" + LocalDateTime.now() + "\","
                + "\"status\":" + status.value() + ","
                + "\"error\":\"" + status.getReasonPhrase() + "\","
                + "\"message\":\"" + sanitize(message) + "\","
                + "\"path\":\"" + path + "\""
                + "}";
    }

    private String sanitize(String message) {
        if (message == null) return "Unexpected error occurred";
        return message.replace("\"", "'");
    }
}