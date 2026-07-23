package com.smart.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NotificationApplication {

    public static void main(String[] args) {

        SpringApplication application =
                new SpringApplication(NotificationApplication.class);

        application.setAdditionalProfiles("notification");
        application.run(args);
    }
}