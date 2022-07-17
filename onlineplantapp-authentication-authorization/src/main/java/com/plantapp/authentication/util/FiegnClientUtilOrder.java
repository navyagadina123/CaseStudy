package com.plantapp.authentication.util;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.plantapp.authentication.models.Order;

@FeignClient(value="Order-Service",url="http://localhost:8084/api/v3")
public interface FiegnClientUtilOrder {
	
	@GetMapping("/allorders") 
	public ResponseEntity<List<Order>> getAllOrders();
	

	@PostMapping("/addOrders") 
	public ResponseEntity<Order> addOrders(@RequestBody Order order);


	@DeleteMapping(path="/orders/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable int id);
	

}