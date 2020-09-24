package com.clearing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("entity")
@EnableJpaRepositories("repository")
@ComponentScan("controller")
@SpringBootApplication
public class ClearingAndSettlementServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClearingAndSettlementServerApplication.class, args);
	}

}
