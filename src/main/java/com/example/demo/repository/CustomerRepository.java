package com.example.demo.repository;

import com.example.demo.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerById(Long id);


//    @Query("SELECT c " +
//            "FROM Customer c" +
//            " WHERE c.id = :id")
//    Customer findCustomerById(Long id);
}
