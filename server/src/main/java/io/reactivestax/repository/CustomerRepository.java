package io.reactivestax.repository;

import io.reactivestax.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
//    List<CustomerRecord> findCustomerByName(String name);

}
