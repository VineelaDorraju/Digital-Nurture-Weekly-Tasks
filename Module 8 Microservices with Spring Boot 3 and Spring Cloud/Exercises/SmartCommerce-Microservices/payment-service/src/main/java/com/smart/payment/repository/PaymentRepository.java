package com.smart.payment.repository;

import com.smart.payment.entity.Payment;
import com.smart.payment.entity.PaymentStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {

    Optional<Payment> findByOrderId(String orderId);

    List<Payment> findByStatus(PaymentStatus status);

    List<Payment> findByAmountGreaterThan(Double amount);

    boolean existsByOrderId(String orderId);

    long countByStatus(PaymentStatus status);
}