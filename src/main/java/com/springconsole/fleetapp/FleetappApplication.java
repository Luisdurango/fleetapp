package com.springconsole.fleetapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@EnableJpaAuditing(auditorAwareRef = "springSecurityAuditor")
@SpringBootApplication
public class FleetappApplication {

	public static void main(String[] args) {
		SpringApplication.run(FleetappApplication.class, args);
	}

}
