package io.reactievstax.kafkaspring.service;

import com.github.javafaker.Faker;
import io.reactievstax.kafkaspring.model.Employee;
import io.reactievstax.kafkaspring.model.EmployeeAddress;
import io.reactievstax.kafkaspring.model.EmployeeAddressHistory;
import io.reactievstax.kafkaspring.repository.AddressRepository;
import io.reactievstax.kafkaspring.repository.EmployeeRepository;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataGenerateService {

    @Autowired
    private Faker faker;

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AddressRepository employeeAddressHistory;

    private int loopCount=10;

    public String generateEmployeeData(){

        for (int i= 1; i<=loopCount;i++) {
            Employee employee = new Employee();
//            employee.setEmpId(i);
            employee.setEmployeeName(faker.name().fullName());
            employee.setAge(faker.number().numberBetween(1, 100));
            employee.setEmailAddress(faker.internet().emailAddress());
            employee.setPhoneNumber(faker.phoneNumber().cellPhone());
            employeeRepository.save(employee);
        }
        return "Employee data has been generated";
    }

    public String generateEmployeeAddressData(){
        for (int i= 1; i<=loopCount;i++) {
            EmployeeAddress employeeAddress = new EmployeeAddress();
//            employeeAddress.setEmpId(i);
            employeeAddress.setState(faker.address().state());
            employeeAddress.setCountryName(faker.address().country());
            employeeAddress.setStreetName(faker.address().streetName());
            employeeAddress.setCityName(faker.address().cityName());
            employeeAddress.setPostalCode(faker.address().countryCode());
            employeeAddress.setStreetNumber(Integer.parseInt(faker.address().streetAddressNumber()));
            employeeAddressHistory.save(employeeAddress);

        }

        return "Employee Address data has been generated";
    }


}
