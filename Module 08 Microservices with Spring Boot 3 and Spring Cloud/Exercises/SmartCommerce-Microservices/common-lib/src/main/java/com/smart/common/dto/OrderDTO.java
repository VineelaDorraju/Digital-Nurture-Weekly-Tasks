package com.smart.order.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {

    private String orderId;
    private String user;
    private List<String> productIds;
    private BigDecimal totalAmount;
    private String status;
    private LocalDateTime createdAt;

    public OrderDTO() {
        this.createdAt = LocalDateTime.now();
    }

    public OrderDTO(String orderId, String user, List<String> productIds,
                    BigDecimal totalAmount, String status) {
        this.orderId = orderId;
        this.user = user;
        this.productIds = productIds;
        this.totalAmount = totalAmount;
        this.status = status;
        this.createdAt = LocalDateTime.now();
    }

    public String getOrderId() {
        return orderId;
    }

    public String getUser() {
        return user;
    }

    public List<String> getProductIds() {
        return productIds;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setProductIds(List<String> productIds) {
        this.productIds = productIds;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}