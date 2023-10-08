package io.reactievstax.kafkaspring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "EmployeeAddressHistory")
@Data
@Builder
public class EmployeeAddressHistory {
    @Id
    @JsonProperty("EMP_ID")
    @Column(name = "EMP_ID")
    private int empId;
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

    @JsonProperty("STREET_NAME")
    @Column(name = "STREET_NAME")
    private String streetName;
    @JsonProperty("STREET_NUMBER")
    @Column(name = "STREET_NUMBER")
    private int streetNumber;
    @JsonProperty("POSTAL_CODE")
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    @JsonProperty("CITY_NAME")
    @Column(name = "CITY_NAME")
    private String cityName;
    @JsonProperty("STATE")
    @Column(name = "STATE")
    private String state;
    @JsonProperty("COUNTRY_NAME")
    @Column(name = "COUNTRY_NAME")
    private String countryName;

}
