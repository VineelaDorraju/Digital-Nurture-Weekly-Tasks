package com.smart.order.client;

import com.smart.common.response.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        name = "PAYMENT-SERVICE",
        path = "/payments"
)
public interface PaymentClient {

    @PostMapping("/process")
    ApiResponse<String> processPayment(
            @RequestParam String orderId,
            @RequestParam Double amount
    );

    @GetMapping("/status/{paymentId}")
    ApiResponse<String> getPaymentStatus(
            @PathVariable String paymentId
    );

    @PostMapping("/refund")
    ApiResponse<String> refundPayment(
            @RequestParam String paymentId
    );
}