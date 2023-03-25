package io.reactivestax.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication
public class EmployeeSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeSpringBootApplication.class, args);
	}

}
