package com.plantapp.authentication.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plantapp.authentication.exception.NoProperDataException;
import com.plantapp.authentication.exception.OrderNotFoundException;
import com.plantapp.authentication.models.Order;
import com.plantapp.authentication.services.SequenceGeneratorService;
import com.plantapp.authentication.util.FiegnClientUtilOrder;

@RestController
@RequestMapping("/api/v3")
public class FiegnControllerOrder {
	
	@Autowired
	private FiegnClientUtilOrder feignclientutilorder;

	@Autowired
	private SequenceGeneratorService service;
	
	@GetMapping("/allorders") 
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Order>> getAllOrders() throws OrderNotFoundException {
	{
		
		return feignclientutilorder.getAllOrders();
		
	}
	
	}
	
@PostMapping("/addOrders")
	@PreAuthorize("hasRole('USER') ")
	public ResponseEntity<Order> addOrders(@RequestBody Order order) throws NoProperDataException {
	
		order.setBookingOrderId(service.getSequenceNumberForOrder(Order.SEQUENCE_NAME));
		return feignclientutilorder.addOrders(order);
	}



	@DeleteMapping(path="/orders/{id}")
	@PreAuthorize("hasRole('USER') ")
	public ResponseEntity<String> deleteOrder(@PathVariable int id) throws OrderNotFoundException {
			return feignclientutilorder.deleteOrder(id);
	}

}
