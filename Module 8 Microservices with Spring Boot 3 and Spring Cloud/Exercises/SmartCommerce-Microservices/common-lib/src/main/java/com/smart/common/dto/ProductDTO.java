package com.smart.product.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductDTO {

    private String productId;
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
    private String category;
    private boolean available;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductDTO() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.available = true;
    }

    public ProductDTO(String productId, String name, String description,
                      BigDecimal price, int stock, String category) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.available = stock > 0;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return available;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
        touch();
    }

    public void setDescription(String description) {
        this.description = description;
        touch();
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
        touch();
    }

    public void setStock(int stock) {
        this.stock = stock;
        this.available = stock > 0;
        touch();
    }

    public void setCategory(String category) {
        this.category = category;
        touch();
    }

    private void touch() {
        this.updatedAt = LocalDateTime.now();
    }
}