package com.santacruz.santacruzregistryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SantacruzRegistryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SantacruzRegistryServerApplication.class, args);
    }

}
