package io.reactivestax.service;

import io.reactivestax.entity.Customer;
import io.reactivestax.record.CustomerRecord;
import io.reactivestax.repository.CustomerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerRecord> findAllCustomers(){
        CriteriaBuilder builder= entityManager.getCriteriaBuilder();
        CriteriaQuery<CustomerRecord> query= builder.createQuery(CustomerRecord.class);
        Root<Customer> root= query.from(Customer.class);
        query.select(builder.construct(CustomerRecord.class,root.get("id"),
                root.get("name"),
                root.get("address")
                ));
        return entityManager.createQuery(query).getResultList();
    }

    public Optional<Customer> findCustomer(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isEmpty()){
            throw new RuntimeException("Customer not found");
        }
    return customer;
    }
}
