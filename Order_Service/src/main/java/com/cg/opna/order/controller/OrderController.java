package com.cg.opna.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.opna.order.exception.NoProperDataException;
import com.cg.opna.order.exception.OrderNotFoundException;
import com.cg.opna.order.model.Order;
import com.cg.opna.order.service.OrderServiceImpl;
import com.cg.opna.order.service.SequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("api/v3")
public class OrderController {
	@Autowired
	private OrderServiceImpl orderServiceimpl;

	@Autowired
	private SequenceGeneratorService service;
	
	@GetMapping("/allorders") 
	public ResponseEntity<List<Order>> getAllOrders() throws OrderNotFoundException {
	{
		log.info("starting  of get mapping");
		return orderServiceimpl.getAllOrders();
		
	}
	
	}
	
	@PostMapping("/addOrders") 
	public ResponseEntity<Order> addOrders(@RequestBody Order order) throws NoProperDataException {
		log.info("start");
		order.setBookingOrderId(service.getSequenceNumberForOrders(Order.SEQUENCE_NAME));
		return orderServiceimpl.addOrders(order);
	}

	@PutMapping("/updateorder/{id}")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable int id) throws OrderNotFoundException {
		return orderServiceimpl.updateOrder(order, id);
	}

	@DeleteMapping(path="/orders/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable int id) throws OrderNotFoundException {
			return orderServiceimpl.deleteOrder(id);
	}

}

