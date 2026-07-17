package com.smart.inventory.service;

import com.smart.inventory.model.Inventory;
import com.smart.inventory.repository.InventoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository repository;

    public int getStock(String productId) {
        Inventory inventory = repository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return inventory.getAvailableQuantity();
    }

    @Transactional
    public void reserveStock(String productId, int quantity) {
        Inventory inventory = repository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        inventory.reserve(quantity);
        repository.save(inventory);
    }

    @Transactional
    public void releaseStock(String productId, int quantity) {
        Inventory inventory = repository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        inventory.release(quantity);
        repository.save(inventory);
    }

    @Transactional
    public void confirmStock(String productId, int quantity) {
        Inventory inventory = repository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (inventory.getReservedQuantity() < quantity) {
            throw new RuntimeException("Invalid confirmation request");
        }

        inventory.setReservedQuantity(
                inventory.getReservedQuantity() - quantity
        );

        repository.save(inventory);
    }

    @Transactional
    public void addStock(String productId, int quantity) {
        Inventory inventory = repository.findById(productId)
                .orElseGet(() -> new Inventory(productId, 0));

        inventory.add(quantity);
        repository.save(inventory);
    }
}