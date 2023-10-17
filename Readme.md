# Spring boot with kafka filter: We are applying filter on messages like if distance greater than 100.

```shell
Steps to run spring boot app:
1. Run docker compose.
2. Run the spring boot app.
3. Login to control center and observe the topic:
    http://localhost:9021
    topic name: car-location-topic

4. The app will send message automatically because we have configured a scheduler class.
5. Below code is doing filtering of message.   

```

```shell

    @Bean(name = "farLocationContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<Object,Object>
    farLocationContainerFactory(ConcurrentKafkaListenerContainerFactoryConfigurer
                                configurer){
        var factory = new ConcurrentKafkaListenerContainerFactory<Object,Object>();
        configurer.configure(factory,consumerFactory());
        factory.setRecordFilterStrategy(new RecordFilterStrategy<Object, Object>() {
            @Override
            public boolean filter(ConsumerRecord<Object, Object> consumerRecord) {
                try{
                    CarLocation carLocation= objectMapper.readValue(consumerRecord.value().toString(),
                            CarLocation.class);
                    return carLocation.getDistance()<=100;
                }catch (JsonProcessingException e){
                    return false;
                }
            }
        });
        return factory;
    }

```

```shell
6. Line no: 24, above code, we are using "recordFilterStrategy" to filter the message.
7. If the filter method returns true, the record is discarded, and if it returns false,
    the record is passed to the listener. So, according to this, you will see only records in which distance
    greater than 100.
    
8. Check the logs and observe the result.    
```