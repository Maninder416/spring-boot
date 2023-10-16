package io.reactievstax.kafkaspring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarLocation {

    private String carId;
    private long timestamp;
    private int distance;
}
