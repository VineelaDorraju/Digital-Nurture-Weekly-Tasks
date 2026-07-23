package com.smart.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserApplication {

    public static void main(String[] args) {

        SpringApplication application =
                new SpringApplication(UserApplication.class);

        application.setAdditionalProfiles("user");
        application.run(args);
    }
}