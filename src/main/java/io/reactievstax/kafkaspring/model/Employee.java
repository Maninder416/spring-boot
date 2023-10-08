package io.reactievstax.kafkaspring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @JsonProperty("EMP_ID")
    @Column(name = "EMP_ID")
    private Integer empId;
    @JsonProperty("EMP_NAME")
    @Column(name = "EMP_NAME")
    private String employeeName;
    @JsonProperty("AGE")
    @Column(name = "AGE")
    private int age;
    @JsonProperty("PHONE_NUMBER")
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @JsonProperty("EMAIL_ADDRESS")
    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;
}
