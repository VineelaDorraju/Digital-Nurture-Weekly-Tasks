package com.smart.inventory.controller;

import com.smart.common.response.ApiResponse;
import com.smart.inventory.service.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService service;

    @GetMapping("/{productId}")
    public ApiResponse<Integer> getStock(@PathVariable String productId) {
        int stock = service.getStock(productId);
        return ApiResponse.success(stock, "Stock fetched");
    }

    @PostMapping("/reserve")
    public ApiResponse<String> reserveStock(@RequestParam String productId,
                                            @RequestParam int quantity) {
        service.reserveStock(productId, quantity);
        return ApiResponse.success("RESERVED", "Stock reserved successfully");
    }

    @PostMapping("/release")
    public ApiResponse<String> releaseStock(@RequestParam String productId,
                                            @RequestParam int quantity) {
        service.releaseStock(productId, quantity);
        return ApiResponse.success("RELEASED", "Stock released successfully");
    }

    @PostMapping("/add")
    public ApiResponse<String> addStock(@RequestParam String productId,
                                       @RequestParam int quantity) {
        service.addStock(productId, quantity);
        return ApiResponse.success("UPDATED", "Stock updated");
    }
}