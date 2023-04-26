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
    @Autowired
    private WebClient webClient;

    @GetMapping("/consumer")
    public List<Customer> fetchCustomers() {
        System.out.println("bean is: "+webClient);
        System.out.println("values are: "+webClient.get());

        Flux<Customer> temp= webClient
                .get()
                .uri("http://localhost:9001/customers")
                .retrieve()
                .bodyToFlux(Customer.class);
        temp.subscribe(customer -> {
            System.out.println("received customer: "+customer);
        });
        return client.getAllCustomers();

    }


}
