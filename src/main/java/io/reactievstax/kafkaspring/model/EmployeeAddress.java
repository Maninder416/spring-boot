package io.reactievstax.kafkaspring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ADDRESS")
@Data
public class EmployeeAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("emp_id")
    @Column(name = "EMP_ID")
    private Integer empId;
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
