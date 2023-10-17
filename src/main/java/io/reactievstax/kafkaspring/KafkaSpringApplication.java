package io.reactievstax.kafkaspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KafkaSpringApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(KafkaSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


	}
}
