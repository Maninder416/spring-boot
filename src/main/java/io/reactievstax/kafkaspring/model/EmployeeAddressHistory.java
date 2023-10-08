package io.reactievstax.kafkaspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EmployeeAddressHistory")
public class EmployeeAddressHistory {
    @Id
    private int empId;
    private String employeeName;
    private int age;
    private int phoneNumber;
    private String emailAddress;
    private String streetName;
    private int streetNumber;
    private String postalCode;
    private String cityName;
    private String state;
    private String countryName;
}
