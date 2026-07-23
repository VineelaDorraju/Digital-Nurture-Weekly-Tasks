package com.smart.product.controller;

import com.smart.common.response.ApiResponse;
import com.smart.product.entity.Product;
import com.smart.product.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ApiResponse<Product> addProduct(@RequestBody Product product) {

        return ApiResponse.success(
                service.addProduct(product),
                "Product added successfully"
        );
    }

    @GetMapping("/{productId}")
    public ApiResponse<Product> getProduct(
            @PathVariable String productId) {

        return ApiResponse.success(
                service.getProduct(productId),
                "Product retrieved successfully"
        );
    }

    @GetMapping
    public ApiResponse<List<Product>> getAllProducts() {

        return ApiResponse.success(
                service.getAllProducts(),
                "Products fetched successfully"
        );
    }

    @GetMapping("/{productId}/availability")
    public ApiResponse<Boolean> checkAvailability(
            @PathVariable String productId,
            @RequestParam int quantity) {

        return ApiResponse.success(
                service.isAvailable(productId, quantity),
                "Availability checked"
        );
    }

    @PutMapping("/{productId}/stock")
    public ApiResponse<String> updateStock(
            @PathVariable String productId,
            @RequestParam int quantity) {

        service.updateStock(productId, quantity);

        return ApiResponse.success(
                "UPDATED",
                "Product stock updated"
        );
    }

    @DeleteMapping("/{productId}")
    public ApiResponse<String> deleteProduct(
            @PathVariable String productId) {

        service.deleteProduct(productId);

        return ApiResponse.success(
                "DELETED",
                "Product removed successfully"
        );
    }
}