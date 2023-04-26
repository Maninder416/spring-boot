package io.reactivestax.controller;

import io.reactivestax.client.CustomerClient;
import io.reactivestax.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class CustomerClientController {

    @Autowired
    private CustomerClient client;

    @GetMapping("/consumer")
    public List<Customer> fetchCustomers() {
        return client.getAllCustomers();

    }


}
