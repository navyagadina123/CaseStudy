package com.cg.opna.order.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		
		List<Order> orders=orderServiceimpl.getAllOrders();
		log.info("starting  of get mapping");
	
		if(orders.isEmpty()) {
			log.debug("orders are {}"
					+ orders);
		 return new  ResponseEntity<>(orders,HttpStatus.OK); 
		}
		else {
			log.debug(" no orders found ");
			 return new  ResponseEntity<>(orders,HttpStatus.NO_CONTENT); 
		}
		
	}
}
	
	
	
@GetMapping("orders/{id}")
public ResponseEntity<Order> getOrderById(@PathVariable  int id) throws OrderNotFoundException {
	Order orders= orderServiceimpl.getOrderById(id);
	if(orders!=null){
	  return ResponseEntity.ok().body(orders);
	}
	  else {
		return new   ResponseEntity(orders,HttpStatus.NOT_FOUND);
	  }

}

	
	@PostMapping("/addOrders") 
	public ResponseEntity<Order> addOrders(@RequestBody Order odto) throws NoProperDataException {

		if(odto!=null) 
		{
			
			odto.setBookingOrderId(service.getSequenceNumberForOrders(Order.SEQUENCE_NAME));
			orderServiceimpl.addOrders(odto);
			log.error("added oders");
			return new ResponseEntity<>(odto,HttpStatus.CREATED);
			
		}
		else
		{
			throw new NoProperDataException("Please fill fields");
			
		}
		
	}
		

	

	@DeleteMapping(path="/orders/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable int id) throws OrderNotFoundException {
		int count=1;
		for(int i=1;i>=count;count++)
		{
			if(count==1)
			{
			try {
				orderServiceimpl.deleteOrder(id);
			} catch (OrderNotFoundException e) {
				log.error(e.getMessage());
			}
			}
			else
			{
				log.info("id not found");
			}
		}
			return ResponseEntity.ok(" deleted operation done ");
	
	}

}

