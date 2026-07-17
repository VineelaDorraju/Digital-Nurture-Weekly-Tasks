package com.smart.order.service;

import com.smart.order.entity.Order;
import com.smart.order.entity.OrderStatus;
import com.smart.order.repository.OrderRepository;
import com.smart.order.saga.OrderSagaOrchestrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderSagaOrchestrator orchestrator;

    public Order placeOrder(Order order) {

        try {

            boolean completed = orchestrator.execute(order);

            if (!completed) {
                throw new RuntimeException("Order processing failed.");
            }

            order.setStatus(OrderStatus.CONFIRMED);

            return repository.save(order);

        } catch (Exception ex) {

            orchestrator.compensate(order);
            order.setStatus(OrderStatus.CANCELLED);

            throw new RuntimeException("Order transaction rolled back.");
        }
    }

    public Order getOrder(Long orderId) {

        return repository.findById(orderId)
                .orElseThrow(() ->
                        new RuntimeException("Order not found."));
    }

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public List<Order> getOrdersByCustomer(String customerId) {
        return repository.findByCustomerId(customerId);
    }

    public List<Order> getOrdersByStatus(OrderStatus status) {
        return repository.findByStatus(status);
    }

    public void cancelOrder(Long orderId) {

        Order order = getOrder(orderId);

        order.setStatus(OrderStatus.CANCELLED);

        repository.save(order);
    }
}