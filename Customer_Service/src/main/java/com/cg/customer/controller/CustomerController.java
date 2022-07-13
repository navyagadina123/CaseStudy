package com.cg.customer.controller;

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
		return customerServiceimpl.getAllCustomers();
		
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable  Integer id)
	throws CustomerNotFoundException{
		return customerServiceimpl.getCustomerById(id);
	}
	
	@PostMapping("/addCustomers") 
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)  throws NoProperDataException
	{
		log.info("start");
		customer.setCust_id(service.getSequenceNumberForCustomer(Customer.SEQUENCE_NAME));
		return customerServiceimpl.addCustomer(customer);
	}

	@PutMapping("/updatecustomer/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer,@PathVariable int id) throws CustomerNotFoundException
	{
		return customerServiceimpl.updateCustomer(customer, id);
	}

	@DeleteMapping(path="/customers/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id) throws CustomerNotFoundException {
			return customerServiceimpl.deleteCustomer(id);
	}
}