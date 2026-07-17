package com.smart.inventory.listener;

import com.smart.inventory.service.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventListener {

    @Autowired
    private InventoryService inventoryService;

    @KafkaListener(topics = "order-created", groupId = "inventory-group")
    public void handleOrderCreated(String message) {
        String[] parts = message.split(":");
        String productId = parts[0];
        int quantity = Integer.parseInt(parts[1]);

        inventoryService.reserveStock(productId, quantity);
    }

    @KafkaListener(topics = "order-cancelled", groupId = "inventory-group")
    public void handleOrderCancelled(String message) {
        String[] parts = message.split(":");
        String productId = parts[0];
        int quantity = Integer.parseInt(parts[1]);

        inventoryService.releaseStock(productId, quantity);
    }

    @KafkaListener(topics = "order-completed", groupId = "inventory-group")
    public void handleOrderCompleted(String message) {
        String[] parts = message.split(":");
        String productId = parts[0];
        int quantity = Integer.parseInt(parts[1]);

        inventoryService.confirmStock(productId, quantity);
    }
}