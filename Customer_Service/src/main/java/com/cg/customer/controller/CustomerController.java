package com.cg.customer.controller;

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

import com.cg.customer.entity.Customer;
import com.cg.customer.exception.CustomerNotFoundException;
import com.cg.customer.exception.NoProperDataException;
import com.cg.customer.service.CustomerServiceImp;
import com.cg.customer.service.SequenceGeneratorService;


import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("api/v2")
public class CustomerController {
	
	@Autowired
	private CustomerServiceImp customerServiceimpl;

	@Autowired
	private SequenceGeneratorService service;
	

	
	@GetMapping("/allcustomers") 
	public ResponseEntity<List<Customer>> getAllCustomer() throws CustomerNotFoundException
	{
		log.info("starting  of get mapping");
		 return new  ResponseEntity<>(customerServiceimpl.getAllCustomers(),HttpStatus.OK); 		
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable  int id)
	throws CustomerNotFoundException{
	
		Customer customers=customerServiceimpl.getCustomerById(id);
	    return ResponseEntity.ok().body(customers);
	}
	
	
	
	@PostMapping("/addCustomers") 
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)  throws NoProperDataException
	{
		log.info("start");
		customer.setCust_id(service.getSequenceNumberForCustomer(Customer.SEQUENCE_NAME));
		return new ResponseEntity<>(customerServiceimpl.addCustomer(customer),HttpStatus.CREATED);
	}

	@DeleteMapping(path="/customers/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id) throws CustomerNotFoundException {
		int count=1;
		for(int i=1;i>=count;count++)
		{
			if(count==1)
			{
			try {
				customerServiceimpl.deleteCustomer(id);
			} catch (CustomerNotFoundException e) {
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
