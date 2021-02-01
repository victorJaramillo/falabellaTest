package com.dev.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.dev.test.*")
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@EntityScan("com.dev.test.*")
@SpringBootApplication
public class DevTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevTestApplication.class, args);
	}

}
