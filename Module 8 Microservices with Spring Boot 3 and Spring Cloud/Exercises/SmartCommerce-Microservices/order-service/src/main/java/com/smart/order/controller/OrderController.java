package com.smart.order.controller;

import com.smart.common.response.ApiResponse;
import com.smart.order.entity.Order;
import com.smart.order.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ApiResponse<Order> placeOrder(@RequestBody Order order) {
        return ApiResponse.success(
                orderService.placeOrder(order),
                "Order placed successfully"
        );
    }

    @GetMapping("/{orderId}")
    public ApiResponse<Order> getOrder(@PathVariable Long orderId) {
        return ApiResponse.success(
                orderService.getOrder(orderId),
                "Order retrieved successfully"
        );
    }

    @GetMapping
    public ApiResponse<List<Order>> getAllOrders() {
        return ApiResponse.success(
                orderService.getAllOrders(),
                "Orders fetched successfully"
        );
    }

    @PutMapping("/{orderId}/cancel")
    public ApiResponse<String> cancelOrder(@PathVariable Long orderId) {
        orderService.cancelOrder(orderId);
        return ApiResponse.success(
                "CANCELLED",
                "Order cancelled successfully"
        );
    }
}