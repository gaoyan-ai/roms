package com.example.asrc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AsrcApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsrcApplication.class, args);
    }

}
