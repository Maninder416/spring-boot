package io.reactivestax.controller;//package io.reactivestax.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
//import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
//import org.springframework.security.oauth2.core.OAuth2AccessToken;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Objects;
//
//@RestController
//@RequiredArgsConstructor
//public class TestController {
//    @Autowired
//    private RestTemplate restTemplate;
//    @Autowired
//    private AuthorizedClientServiceOAuth2AuthorizedClientManager manager;
//
//    @GetMapping("/test")
//    public String testing(){
//        OAuth2AuthorizeRequest request= OAuth2AuthorizeRequest.withClientRegistrationId("okta")
//                        .principal("Demo Service")
//                                .build();
//
//        OAuth2AuthorizedClient client= this.manager.authorize(request);
//        OAuth2AccessToken token= Objects.requireNonNull(client).getAccessToken();
//        HttpHeaders headers= new HttpHeaders();
//        headers.add("Authorization","Bearer "+token.getTokenValue());
//        HttpEntity request2= new HttpEntity(headers);
//
//
//        System.out.println("bean is: "+restTemplate.toString());
////        ResponseEntity<String> response = restTemplate.
////                getForEntity("http://localhost:9001/books",String.class);
//        ResponseEntity<String> response = restTemplate.
//                exchange(
//                        "http://localhost:9001/books",
//                        HttpMethod.GET,
//                        request2,
//                        String.class
//
//                );
//        return response.getBody();
//    }
//
//
//
//
//}
