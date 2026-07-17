package com.smart.notification.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    public void sendOrderCreatedNotification(String message) {
        logNotification(
                "Order Created",
                "Your order has been placed successfully.",
                message
        );
    }

    public void sendOrderCompletedNotification(String message) {
        logNotification(
                "Order Completed",
                "Your order has been delivered successfully.",
                message
        );
    }

    public void sendOrderCancelledNotification(String message) {
        logNotification(
                "Order Cancelled",
                "Your order has been cancelled.",
                message
        );
    }

    public void sendPaymentSuccessNotification(String message) {
        logNotification(
                "Payment Successful",
                "Your payment has been received successfully.",
                message
        );
    }

    public void sendPaymentFailureNotification(String message) {
        logNotification(
                "Payment Failed",
                "Unfortunately, your payment could not be processed.",
                message
        );
    }

    private void logNotification(String subject, String content, String details) {


        System.out.println("Notification Time : " + LocalDateTime.now());
        System.out.println("Subject           : " + subject);
        System.out.println("Message           : " + content);
        System.out.println("Event Details     : " + details);
        System.out.println("Status            : SENT");
 
    }
}