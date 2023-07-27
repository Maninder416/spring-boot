package io.reactivestax.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order-payment")
    public String invokePaymentService() {
        log.info("***** port is: *****: "+port);
        String url = "http://PAYMENT-SERVICE/payment";
        log.info("****** Invoking payment method ******");
        return restTemplate.getForObject(url, String.class);
    }
}
