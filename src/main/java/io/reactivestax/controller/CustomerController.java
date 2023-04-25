package io.reactivestax.controller;

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

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody CustomerRecord customer) {
        Customer customerRecord = new Customer(customer.name(), customer.address());
        log.info("***** Customer data saved *****");
        return customerRepository.save(customerRecord);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return customerRepository.findById(id).stream().filter(customer -> customer.getId()==id)
                .findAny().orElseThrow(()->new RuntimeException("Customer not found for id: "+id));
    }


}
