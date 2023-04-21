package io.reactivestax.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@RestController
@Slf4j
public class TestController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private AuthorizedClientServiceOAuth2AuthorizedClientManager manager;

    @GetMapping("/books")
    public String getAllBooks(){
        OAuth2AuthorizeRequest request3= OAuth2AuthorizeRequest.withClientRegistrationId("okta")
                        .principal("Demo Service")
                                .build();

        OAuth2AuthorizedClient client= this.manager.authorize(request3);
        OAuth2AccessToken token= Objects.requireNonNull(client).getAccessToken();
        log.info("***** token is: *****: "+token.getTokenValue());
        HttpHeaders headers= new HttpHeaders();
        headers.add("Authorization","Bearer " + token.getTokenValue());
        HttpEntity request= new HttpEntity(headers);
        ResponseEntity<String> response = restTemplate.
                exchange(
                        "http://localhost:9001/books",
                        HttpMethod.GET,
                        request,
                        String.class

                );
        log.info("***** response is: ****** : "+response.getBody());
        return response.getBody();
    }




}
