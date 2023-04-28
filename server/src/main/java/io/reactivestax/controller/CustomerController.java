package io.reactivestax.controller;

import io.micrometer.observation.ObservationRegistry;
import io.reactivestax.entity.Customer;
import io.reactivestax.record.CustomerRecord;
import io.reactivestax.repository.CustomerRepository;
import io.reactivestax.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ObservationRegistry registry;


    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody CustomerRecord customer) {
        Customer customerRecord = new Customer(customer.name(), customer.address());
        return customerService.saveCustomer(customerRecord);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        System.out.println("bean is: "+registry);
        return customerService.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.findCustomerById(id);
    }


}
