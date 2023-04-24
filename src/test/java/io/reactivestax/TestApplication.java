package io.reactivestax;

import org.springframework.boot.SpringApplication;

public class TestApplication {
    public static void main(String[] args) {
        SpringApplication
                .from(TestingContainerApplication::main)
                .with(TestContainersConfiguration.class)
                .run(args);
    }
}
