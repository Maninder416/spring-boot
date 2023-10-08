package io.reactievstax.kafkaspring.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    private int empId;
    private String employeeName;
    private int age;
    private int phoneNumber;
    private String emailAddress;
}
