package com.cg.customer.controller;

import java.util.List;

import javax.validation.Valid;

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
		
		List<Customer> customers=customerServiceimpl.getAllCustomers();
		log.info("starting  of get mapping");
	
		if(customers.size()>0) {
			log.debug("customers are {}"
					+ customers);
		 return new  ResponseEntity<>(customers,HttpStatus.OK); 
		}
		else {
			log.debug(" no customers found ");
			 return new  ResponseEntity<>(customers,HttpStatus.NO_CONTENT); 
		}
	}
	
	
	

	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@Valid @PathVariable  int id)
	throws CustomerNotFoundException	
		
		{
			log.info("starting  of get mapping");
			Customer customers=customerServiceimpl.getCustomerById(id);
		
			if(customers.getCust_id()!=0) {
				log.debug("customers are {}"
						+ customers);
			 return new  ResponseEntity<>(customers,HttpStatus.OK); 
			}
			else {
				log.debug(" no customers found ");
				 return new  ResponseEntity<>(customers,HttpStatus.NOT_FOUND); 
			}
		}
		
	
	@PostMapping("/addCustomers") 
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer)  throws NoProperDataException
	{
		if(customer!=null) 
		{
			
			customer.setCust_id(service.getSequenceNumberForCustomer(Customer.SEQUENCE_NAME));
			customerServiceimpl.addCustomer(customer);
			log.error("added customer");
			return new ResponseEntity<>(customer,HttpStatus.CREATED);
			
		}
		else
		{
			throw new NoProperDataException("Please fill fields");
		}
		
		
	}

	

	@DeleteMapping(path="/customers/{id}")
	public ResponseEntity<String> deleteCustomer(@Valid @PathVariable int id) throws CustomerNotFoundException {
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
