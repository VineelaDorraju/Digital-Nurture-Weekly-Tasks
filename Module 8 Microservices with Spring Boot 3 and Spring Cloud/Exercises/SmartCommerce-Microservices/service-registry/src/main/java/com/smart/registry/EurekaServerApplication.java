package com.smart.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceApplication {

    public static void main(String[] args) {

        SpringApplication application =
                new SpringApplication(EurekaServiceApplication.class);

        application.setAdditionalProfiles("eureka");
        application.run(args);
    }
}