package com.tasktrack_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.mapping.event.ValidatingEntityCallback;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class TasktrackApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(TasktrackApiApplication.class, args);
	}

	@Bean
	public ValidatingEntityCallback validatingEntityCallback(LocalValidatorFactoryBean validator) {
		return new ValidatingEntityCallback(validator);
	}
}
