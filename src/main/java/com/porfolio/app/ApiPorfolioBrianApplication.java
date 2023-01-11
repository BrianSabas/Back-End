package com.porfolio.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@EnableJpaRepositories
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.porfolio.app"})
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ApiPorfolioBrianApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPorfolioBrianApplication.class, args);
	}

}
