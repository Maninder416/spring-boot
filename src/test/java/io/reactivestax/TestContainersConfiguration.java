package io.reactivestax;

import org.springframework.boot.test.context.TestConfiguration;
import org.testcontainers.containers.MySQLContainer;

@TestConfiguration(proxyBeanMethods = false)
public class TestContainersConfiguration {

    public MySQLContainer<?> mySQLContainer(){
        return new MySQLContainer<>("mysql:8.0.27");

    }


}
