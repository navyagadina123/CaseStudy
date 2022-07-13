package com.cg.opna.order.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.opna.order.exception.NoProperDataException;
import com.cg.opna.order.exception.OrderNotFoundException;
import com.cg.opna.order.model.Order;


public interface OrderService {
	public  ResponseEntity<List<Order>> getAllOrders() throws  OrderNotFoundException;
	public ResponseEntity<Order> getOrderById(@PathVariable int id) throws OrderNotFoundException;
	public ResponseEntity<Order> addOrders(@RequestBody Order order)  throws NoProperDataException;
	public ResponseEntity<Order> updateOrder(@RequestBody Order order ,@PathVariable int id)  throws OrderNotFoundException;
	public ResponseEntity<String> deleteOrder(@PathVariable int id) throws OrderNotFoundException;
}
