package com.example.serverlayanglayang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServerLayangLayangApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerLayangLayangApplication.class, args);
    }

}
