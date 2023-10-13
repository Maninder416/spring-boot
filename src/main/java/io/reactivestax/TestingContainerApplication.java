package io.reactivestax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan(basePackages = {"io.reactivestax.controller"})
public class TestingContainerApplication {



	public static void main(String[] args) {
		SpringApplication.run(TestingContainerApplication.class, args);
	}

}

