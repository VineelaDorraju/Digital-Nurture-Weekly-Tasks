package com.smart.payment.service;

import com.smart.payment.entity.Payment;
import com.smart.payment.entity.PaymentStatus;
import com.smart.payment.event.PaymentEventPublisher;
import com.smart.payment.repository.PaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    @Autowired
    private PaymentEventPublisher publisher;

    public String processPayment(String orderId, Double amount) {

        Payment payment = new Payment();
        payment.setOrderId(orderId);
        payment.setAmount(amount);
        payment.setTransactionReference(
                "TXN-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase()
        );
        payment.setStatus(PaymentStatus.SUCCESS);

        repository.save(payment);

        publisher.publishPaymentSuccess(payment.getPaymentId());

        return payment.getPaymentId();
    }

    public Payment getPayment(String paymentId) {

        return repository.findById(paymentId)
                .orElseThrow(() ->
                        new RuntimeException("Payment not found"));
    }

    public String getPaymentStatus(String paymentId) {

        return getPayment(paymentId)
                .getStatus()
                .name();
    }

    public void refundPayment(String paymentId) {

        Payment payment = getPayment(paymentId);

        payment.setStatus(PaymentStatus.REFUNDED);

        repository.save(payment);

        publisher.publishRefund(paymentId);
    }

    public void markPaymentFailed(String paymentId) {

        Payment payment = getPayment(paymentId);

        payment.setStatus(PaymentStatus.FAILED);

        repository.save(payment);

        publisher.publishPaymentFailure(paymentId);
    }
}