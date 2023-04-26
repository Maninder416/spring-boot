package io.reactivestax.client;

import io.reactivestax.entity.Customer;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface CustomerClient {

    @GetExchange
    List<Customer> getAllCustomers();

}
