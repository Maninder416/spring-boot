package io.reactievstax.kafkaspring;

import com.github.javafaker.Faker;
import io.reactievstax.kafkaspring.service.DataGenerateService;
import io.reactievstax.kafkaspring.stream.EmployeeDetailsAndAddressStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaSpringApplication implements CommandLineRunner {

	@Autowired
	private Faker faker;

	@Autowired
	private DataGenerateService dataGenerateService;

	@Autowired
	private EmployeeDetailsAndAddressStream employeeDetailsAndAddressStream;

	public static void main(String[] args) {
		SpringApplication.run(KafkaSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("calling this method");
		dataGenerateService.generateEmployeeData();
		dataGenerateService.generateEmployeeAddressData();
		employeeDetailsAndAddressStream.employeeDetails();

	}
}
