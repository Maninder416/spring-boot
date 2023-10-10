package io.reactievstax.kafkaspring.utils;

public enum Topic {
    EMPLOYEE_TOPIC("employee"),
    ADDRESS_TOPIC("address"),
    EMPLOYEE_ADDRESS_TOPIC("employee_basic_and_address_details");


    private final String topicName;

    Topic(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicName() {
        return topicName;
    }


}
