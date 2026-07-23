package com.smart.order.saga;

import com.smart.common.response.ApiResponse;
import com.smart.order.client.PaymentClient;
import com.smart.order.client.ProductClient;
import com.smart.order.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderSagaOrchestrator {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private PaymentClient paymentClient;

    public boolean execute(Order order) {

        ApiResponse<Boolean> stockResponse =
                productClient.checkAvailability(
                        order.getProductId(),
                        order.getQuantity()
                );

        if (!Boolean.TRUE.equals(stockResponse.getData())) {
            throw new RuntimeException("Product is out of stock.");
        }

        ApiResponse<String> paymentResponse =
                paymentClient.processPayment(
                        order.getOrderId().toString(),
                        order.getTotalAmount().doubleValue()
                );

        return "SUCCESS".equalsIgnoreCase(paymentResponse.getData());
    }

    public void compensate(Order order) {

        paymentClient.refundPayment(order.getOrderId().toString());

        productClient.updateStock(
                order.getProductId(),
                order.getQuantity()
        );
    }
}