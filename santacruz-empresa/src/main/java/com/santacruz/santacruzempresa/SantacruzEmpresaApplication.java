package com.santacruz.santacruzempresa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SantacruzEmpresaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SantacruzEmpresaApplication.class, args);
	}

}
