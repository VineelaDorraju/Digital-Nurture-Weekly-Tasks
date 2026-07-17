package com.smart.payment.controller;

import com.smart.common.response.ApiResponse;
import com.smart.payment.entity.Payment;
import com.smart.payment.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public ApiResponse<String> processPayment(
            @RequestParam String orderId,
            @RequestParam Double amount) {

        String paymentId = paymentService.processPayment(orderId, amount);

        return ApiResponse.success(
                paymentId,
                "Payment processed successfully"
        );
    }

    @GetMapping("/status/{paymentId}")
    public ApiResponse<String> paymentStatus(
            @PathVariable String paymentId) {

        return ApiResponse.success(
                paymentService.getPaymentStatus(paymentId),
                "Payment status retrieved"
        );
    }

    @PostMapping("/refund")
    public ApiResponse<String> refundPayment(
            @RequestParam String paymentId) {

        paymentService.refundPayment(paymentId);

        return ApiResponse.success(
                "REFUNDED",
                "Refund completed successfully"
        );
    }

    @GetMapping("/{paymentId}")
    public ApiResponse<Payment> getPayment(
            @PathVariable String paymentId) {

        return ApiResponse.success(
                paymentService.getPayment(paymentId),
                "Payment details fetched"
        );
    }
}