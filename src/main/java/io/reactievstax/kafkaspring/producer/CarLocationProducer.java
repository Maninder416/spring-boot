package io.reactievstax.kafkaspring.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.reactievstax.kafkaspring.model.CarLocation;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CarLocationProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void send(CarLocation carLocation) throws JsonProcessingException {
        var json = objectMapper.writeValueAsString(carLocation);
        kafkaTemplate.send("car-location-topic",json);
    }
}
