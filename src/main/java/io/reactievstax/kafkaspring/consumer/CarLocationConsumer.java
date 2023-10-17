package io.reactievstax.kafkaspring.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.reactievstax.kafkaspring.model.CarLocation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CarLocationConsumer {
    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "car-location-topic",groupId = "cg-all-location")
    public void listenAll(String message) throws JsonProcessingException {
        var carLocation= objectMapper.readValue(message, CarLocation.class);
        log.info("listen all : {} ",carLocation);
    }

    @KafkaListener(topics = "car-location-topic", groupId = "cg-far-location",
            containerFactory = "farLocationContainerFactory")
    public void listenFar(String message) throws JsonProcessingException {
        var carLocation = objectMapper.readValue(message, CarLocation.class);
        log.info("***** filter messages are ***** : {} ",carLocation);

    }


}
