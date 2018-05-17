package com.rubensaraujo.TakeaFlight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = { "com.rubensaraujo.TakeaFlight.Repository"})
public class TakeaFlightApplication {

	public static void main(String[] args) {
		SpringApplication.run(TakeaFlightApplication.class, args);
	}
}
