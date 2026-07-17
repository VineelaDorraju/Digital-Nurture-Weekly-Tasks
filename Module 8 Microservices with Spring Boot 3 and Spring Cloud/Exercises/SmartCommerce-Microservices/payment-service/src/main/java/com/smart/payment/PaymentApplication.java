package com.smart.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplication {

    public static void main(String[] args) {

        SpringApplication application =
                new SpringApplication(PaymentApplication.class);

        application.setAdditionalProfiles("payment");
        application.run(args);
    }
}