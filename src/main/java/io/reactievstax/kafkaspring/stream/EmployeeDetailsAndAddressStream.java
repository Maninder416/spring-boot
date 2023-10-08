package io.reactievstax.kafkaspring.stream;

import io.reactievstax.kafkaspring.config.KStreamConfig;
import io.reactievstax.kafkaspring.model.Employee;
import io.reactievstax.kafkaspring.model.EmployeeAddress;
import io.reactievstax.kafkaspring.model.EmployeeAddressHistory;
import io.reactievstax.kafkaspring.utils.Topic;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@Slf4j
public class EmployeeDetailsAndAddressStream {
    @Autowired
    private KStreamConfig kStreamConfig;

    public void employeeDetails(){
        StreamsBuilder builder = new StreamsBuilder();
        final Serde<Employee> employeeSerde = Serdes.serdeFrom(new JsonSerializer<>(), new JsonDeserializer<>(Employee.class));
        KStream<String,Employee> employeeKStream = builder.stream(Topic.EMPLOYEE_TOPIC.getTopicName(),
                Consumed.with(Serdes.String(),employeeSerde));
        log.info("****** Employee basic data stream *****");
        employeeKStream.print(Printed.toSysOut());
        employeeKStream.foreach((key,value)->
                log.info("***** Key value for employee details: :{} :{}",key,value));


        final Serde<EmployeeAddress> employeeAddressSerde = Serdes.serdeFrom(new JsonSerializer<>(),new JsonDeserializer<>(EmployeeAddress.class));
        KStream<String,EmployeeAddress> employeeAddressKStream = builder.stream(Topic.ADDRESS_TOPIC.getTopicName(),
                Consumed.with(Serdes.String(),employeeAddressSerde));
        log.info("***** Employee address data stream *****");
        employeeAddressKStream.print(Printed.toSysOut());
        employeeAddressKStream.foreach((key,value)->
                log.info("***** Key value for Employee address details: :{} :{} ",key,value));

        ValueJoiner<Employee,EmployeeAddress, EmployeeAddressHistory> joiner =
                (employee, address)->
                        EmployeeAddressHistory.builder()
                                .empId(employee.getEmpId())
                                .employeeName(employee.getEmployeeName())
                                .age(employee.getAge())
                                .emailAddress(employee.getEmailAddress())
                                .phoneNumber(employee.getPhoneNumber())
                                .streetName(address.getStreetName())
                                .state(address.getState())
                                .cityName(address.getCityName())
                                .countryName(address.getCountryName())
                                .postalCode(address.getPostalCode())
                                .build();

        KStream<String,EmployeeAddressHistory> employeeAddressHistoryOutputKStream =
                employeeKStream.join(employeeAddressKStream,joiner, JoinWindows.of(Duration.ofSeconds(3000))
                ,StreamJoined.with(Serdes.String(),employeeSerde,employeeAddressSerde));

        employeeAddressHistoryOutputKStream.print(Printed.toSysOut());
        employeeAddressHistoryOutputKStream.foreach((key,value)->
                log.info("****** key and value for employee and history stream *****: :{} :{}",key,value));

        employeeAddressHistoryOutputKStream.to(Topic.EMPLOYEE_ADDRESS_TOPIC.getTopicName(),
                Produced.with(Serdes.String(), new JsonSerde<>(EmployeeAddressHistory.class)));

        kStreamConfig.topology(builder);

    }
}
