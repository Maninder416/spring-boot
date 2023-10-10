package io.reactievstax.kafkaspring.config;

import io.reactievstax.kafkaspring.utils.Topic;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {

    @Bean
    public NewTopic employeeDetailsTopic() {
        return TopicBuilder.name(Topic.EMPLOYEE_TOPIC.getTopicName())
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic employeeAddressDetailsTopic() {
        return TopicBuilder.name(Topic.ADDRESS_TOPIC.getTopicName())
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic employeeAddressDetailsFinalOutputTopic() {
        return TopicBuilder.name(Topic.EMPLOYEE_ADDRESS_TOPIC.getTopicName())
                .partitions(1)
                .replicas(1)
                .build();
    }

}
