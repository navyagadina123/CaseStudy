package com.cg.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.customer.entity.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Integer> {

}
