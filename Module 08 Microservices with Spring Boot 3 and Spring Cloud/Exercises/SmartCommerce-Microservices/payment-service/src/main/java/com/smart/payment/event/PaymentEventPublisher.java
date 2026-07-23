package com.smart.payment.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventPublisher {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publishPaymentSuccess(String paymentId) {
        kafkaTemplate.send("payment-success", paymentId);
    }

    public void publishPaymentFailure(String paymentId) {
        kafkaTemplate.send("payment-failed", paymentId);
    }

    public void publishRefund(String paymentId) {
        kafkaTemplate.send("payment-refunded", paymentId);
    }
}