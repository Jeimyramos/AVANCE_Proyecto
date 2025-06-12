package com.santacruz.santacruzventa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SantacruzVentaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SantacruzVentaApplication.class, args);
    }

}
