package com.santacruz.santacruzalmacen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SantacruzAlmacenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SantacruzAlmacenApplication.class, args);
	}

}
