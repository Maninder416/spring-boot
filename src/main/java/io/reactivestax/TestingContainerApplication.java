package io.reactivestax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TestingContainerApplication {

	@GetMapping("/test")
	public String get(){
		return "hello";
	}

	public static void main(String[] args) {
		SpringApplication.run(TestingContainerApplication.class, args);
	}

}

