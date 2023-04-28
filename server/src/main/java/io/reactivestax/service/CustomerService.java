package io.reactivestax.service;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import io.reactivestax.entity.Customer;
import io.reactivestax.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ObservationRegistry registry;

    public Customer saveCustomer(Customer customer) {

        Customer customer1 = customerRepository.save(customer);
        log.info("***** Customer data saved *****");
        return Observation.createNotStarted("addCustomer", registry)
                .observe(() -> customer);
    }

    public List<Customer> findAll() {
        return Observation.createNotStarted("getCustomers", registry)
                .observe(() -> customerRepository.findAll());
    }

    public Customer findCustomerById(Long id) {
        return Observation.createNotStarted("getCustomer", registry)
                .observe(() -> customerRepository.findById(id).stream().filter(
                                customer -> customer.getId() == id)
                        .findAny().orElseThrow(() -> new RuntimeException("Customer not found for id: " + id)));

    }

}
