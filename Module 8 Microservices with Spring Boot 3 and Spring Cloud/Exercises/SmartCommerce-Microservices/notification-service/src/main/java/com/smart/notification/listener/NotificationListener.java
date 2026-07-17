package com.smart.notification.listener;

import com.smart.notification.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    @Autowired
    private EmailService emailService;

    @KafkaListener(topics = "order-created", groupId = "notification-group")
    public void orderCreated(String message) {
        emailService.sendOrderCreatedNotification(message);
    }

    @KafkaListener(topics = "order-completed", groupId = "notification-group")
    public void orderCompleted(String message) {
        emailService.sendOrderCompletedNotification(message);
    }

    @KafkaListener(topics = "order-cancelled", groupId = "notification-group")
    public void orderCancelled(String message) {
        emailService.sendOrderCancelledNotification(message);
    }

    @KafkaListener(topics = "payment-success", groupId = "notification-group")
    public void paymentSuccess(String message) {
        emailService.sendPaymentSuccessNotification(message);
    }

    @KafkaListener(topics = "payment-failed", groupId = "notification-group")
    public void paymentFailed(String message) {
        emailService.sendPaymentFailureNotification(message);
    }
}