package io.reactievstax.kafkaspring.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;
import java.util.UUID;

@Configuration
public class KStreamConfig {

    @Value("${kafka.schema-registry}")
    public String SCHEMA_REGISTRY_URL;
    @Value("${kafka.bootstrap-server}")
    public String KAFKA_BOOTSTRAP_SERVER;
    @Value("${kafka.application-id}")
    public String PRODUCT_CATEGORY_APP_ID;

    public Properties properties() {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, UUID.randomUUID().toString());
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_BOOTSTRAP_SERVER);
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, 0);
        props.put("schema.registry.url", SCHEMA_REGISTRY_URL);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("group.id", "my-group-id");
        return props;
    }

    /**
     * Creating the common topology for all streams
     *
     * @param builder
     */
    public void topology(StreamsBuilder builder) {
        final Topology topology = builder.build();
        KafkaStreams kafkaStreams = new KafkaStreams(topology, properties());
        kafkaStreams.cleanUp();
        kafkaStreams.start();
        Runtime.getRuntime().addShutdownHook(new Thread(kafkaStreams::close));
    }
}
