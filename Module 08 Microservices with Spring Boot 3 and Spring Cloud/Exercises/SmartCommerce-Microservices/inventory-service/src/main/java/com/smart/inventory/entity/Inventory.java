package com.smart.inventory.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    private String productId;

    @Column(nullable = false)
    private int availableQuantity;

    @Column(nullable = false)
    private int reservedQuantity;

    private LocalDateTime updatedAt;

    public Inventory() {
        this.updatedAt = LocalDateTime.now();
    }

    public Inventory(String productId, int availableQuantity) {
        this.productId = productId;
        this.availableQuantity = availableQuantity;
        this.reservedQuantity = 0;
        this.updatedAt = LocalDateTime.now();
    }

    public String getProductId() {
        return productId;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public int getReservedQuantity() {
        return reservedQuantity;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
        touch();
    }

    public void setReservedQuantity(int reservedQuantity) {
        this.reservedQuantity = reservedQuantity;
        touch();
    }

    public void reserve(int quantity) {
        if (availableQuantity < quantity) {
            throw new RuntimeException("Insufficient stock");
        }
        this.availableQuantity -= quantity;
        this.reservedQuantity += quantity;
        touch();
    }

    public void release(int quantity) {
        if (reservedQuantity < quantity) {
            throw new RuntimeException("Invalid release request");
        }
        this.reservedQuantity -= quantity;
        this.availableQuantity += quantity;
        touch();
    }

    public void add(int quantity) {
        this.availableQuantity += quantity;
        touch();
    }

    private void touch() {
        this.updatedAt = LocalDateTime.now();
    }
}