package com.cg.opna.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.opna.order.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Integer> {

}
