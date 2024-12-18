package com.ashospital.tuxpan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ashospital.tuxpan.repositories")
@ComponentScan(basePackages = "com.ashospital.tuxpan")
@EntityScan(basePackages = "com.ashospital.tuxpan.models")
public class TuxpanApplication {

	public static void main(String[] args) {
		SpringApplication.run(TuxpanApplication.class, args);
	}

}