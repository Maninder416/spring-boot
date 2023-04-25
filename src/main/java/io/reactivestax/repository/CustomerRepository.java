package io.reactivestax.repository;

import io.reactivestax.entity.Customer;
import io.reactivestax.record.CustomerRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
//    List<CustomerRecord> findCustomerByName(String name);

}
