package io.reactievstax.kafkaspring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("emp_id")
    @Column(name = "EMP_ID")
    private Integer empId;
    @JsonProperty("emp_name")
    @Column(name = "EMP_NAME")
    private String employeeName;
    @JsonProperty("age")
    @Column(name = "AGE")
    private int age;
    @JsonProperty("phone_number")
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @JsonProperty("email_address")
    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;
}
