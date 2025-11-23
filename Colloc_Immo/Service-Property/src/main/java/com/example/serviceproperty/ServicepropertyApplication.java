package com.example.serviceproperty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServicepropertyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicepropertyApplication.class, args);
    }

}
