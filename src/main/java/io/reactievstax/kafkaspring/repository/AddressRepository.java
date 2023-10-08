package io.reactievstax.kafkaspring.repository;

import io.reactievstax.kafkaspring.model.EmployeeAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<EmployeeAddress,Integer> {
}
