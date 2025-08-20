package com.samuelmaia1.github.marca_ai_api.marca_ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class MarcaAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarcaAiApplication.class, args);
	}

}