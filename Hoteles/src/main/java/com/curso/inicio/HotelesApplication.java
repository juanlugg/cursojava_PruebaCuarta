package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Clase inicial de ejecución y enlace del proyecto para hoteles
 * @author Juan Luis Guerra Gennich 31/12/2024
 * @version 1.0.0 
 */
@EntityScan(basePackages = "com.curso.model")
@EnableJpaRepositories(basePackages = "com.curso.repository")
@SpringBootApplication(scanBasePackages = { "com.curso.service", "com.curso.controller" })
public class HotelesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelesApplication.class, args);
	}
}
