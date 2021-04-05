package com.example.acms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AcmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcmsApplication.class, args);
    }

}
