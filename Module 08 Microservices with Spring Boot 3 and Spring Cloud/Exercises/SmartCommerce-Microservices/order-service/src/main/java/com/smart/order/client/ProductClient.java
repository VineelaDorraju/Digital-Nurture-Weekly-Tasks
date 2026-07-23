package com.smart.order.client;

import com.smart.common.response.ApiResponse;
import com.smart.product.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        name = "PRODUCT-SERVICE",
        path = "/products"
)
public interface ProductClient {

    @GetMapping("/{productId}")
    ApiResponse<ProductDTO> getProduct(
            @PathVariable String productId
    );

    @GetMapping("/{productId}/availability")
    ApiResponse<Boolean> checkAvailability(
            @PathVariable String productId,
            @RequestParam int quantity
    );

    @PutMapping("/{productId}/stock")
    ApiResponse<String> updateStock(
            @PathVariable String productId,
            @RequestParam int quantity
    );
}