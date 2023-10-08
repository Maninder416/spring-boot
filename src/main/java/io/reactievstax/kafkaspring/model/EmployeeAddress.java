package io.reactievstax.kafkaspring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ADDRESS")
@Data
public class EmployeeAddress {
    @Id
    @JsonProperty("EMP_ID")
    @Column(name = "EMP_ID")
    private Integer empId;
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
