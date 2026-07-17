package com.smart.order.repository;

import com.smart.order.entity.Order;
import com.smart.order.entity.OrderStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomerId(String customerId);

    List<Order> findByStatus(OrderStatus status);

    List<Order> findByProductId(String productId);

    List<Order> findByCustomerIdAndStatus(String customerId, OrderStatus status);

    long countByStatus(OrderStatus status);

    boolean existsByCustomerIdAndProductId(String customerId, String productId);
}