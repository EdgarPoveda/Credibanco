package com.credibanco.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@ComponentScan({"com.credibanco.assessment.library.controller",
	"com.credibanco.assessment.library.model.dao",
	"com.credibanco.assessment.library.model.dao.impl",
	"com.credibanco.assessment.library.service",
	"com.credibanco.assessment.library.service.impl"
})
@EntityScan(basePackages = {"com.credibanco.assessment.library.model"})
@EnableJpaRepositories(basePackages = {"com.credibanco.assessment.library.model.dao"})
@SpringBootApplication
public class CredibancoApplication { 

	public static void main(String[] args) {
		SpringApplication.run(CredibancoApplication.class, args);
	}

}
