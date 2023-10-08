package io.reactievstax.kafkaspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class EmployeeAddress {
    @Id
    private int empId;
    private String streetName;
    private int streetNumber;
    private String postalCode;
    private String cityName;
    private String state;
    private String countryName;


}
