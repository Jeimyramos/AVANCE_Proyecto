package com.santacruz.santacruzauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SantacruzAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SantacruzAuthApplication.class, args);
    }

}
