package io.reactievstax.kafkaspring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "EmployeeAddressHistory")
@Data
@Builder
public class EmployeeAddressHistory {

    @Id
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

    @JsonProperty("street_name")
    @Column(name = "STREET_NAME")
    private String streetName;
    @JsonProperty("street_number")
    @Column(name = "STREET_NUMBER")
    private int streetNumber;
    @JsonProperty("postal_code")
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    @JsonProperty("city_name")
    @Column(name = "CITY_NAME")
    private String cityName;
    @JsonProperty("state")
    @Column(name = "STATE")
    private String state;
    @JsonProperty("country_name")
    @Column(name = "COUNTRY_NAME")
    private String countryName;

}
