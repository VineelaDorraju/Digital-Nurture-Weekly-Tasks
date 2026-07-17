package com.smart.common.client;

import com.smart.common.response.ApiResponse;
import com.smart.user.dto.UserDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "AUTH-SERVICE",
        path = "/auth"
)
public interface AuthClient {

    @GetMapping("/validate")
    ApiResponse<Boolean> validateToken(
            @RequestHeader("Authorization") String token
    );

    @GetMapping("/profile")
    ApiResponse<UserDTO> getUserProfile(
            @RequestHeader("Authorization") String token
    );
}