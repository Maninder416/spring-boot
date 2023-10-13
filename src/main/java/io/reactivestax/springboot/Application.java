package io.reactivestax.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	@GetMapping("/")
    	public String get(){
        	return "hello team. I am deploying application";
    		}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

