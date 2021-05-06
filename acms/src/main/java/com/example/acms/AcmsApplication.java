package com.example.acms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Objects;

@SpringBootApplication
@EnableEurekaClient
@EnableScheduling
public class AcmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcmsApplication.class, args);
    }

}
