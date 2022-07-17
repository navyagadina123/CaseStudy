package com.plantapp.authentication.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plantapp.authentication.exception.CustomerNotFoundException;
import com.plantapp.authentication.exception.NoProperDataException;
import com.plantapp.authentication.models.Customer;
import com.plantapp.authentication.services.SequenceGeneratorService;
import com.plantapp.authentication.util.FiegnClientUtilCustomer;
@RestController
@RequestMapping("/api/v2")
public class FeignControllerCustomer {
	

	@Autowired
	private FiegnClientUtilCustomer feigncustomer;
	
	
	@Autowired
	private SequenceGeneratorService service;

	@GetMapping("/allcustomers") 
	@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
	public ResponseEntity<List<Customer>> getAllCustomer() throws CustomerNotFoundException
	{
		
		return feigncustomer.getAllCustomer();
		
	}
	
	@GetMapping("/customers/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Customer> getCustomerById(@Valid @PathVariable  Integer id)
	throws CustomerNotFoundException{
		return feigncustomer.getCustomerById(id);
	}
	
	@PostMapping("/addCustomers") 
 @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer)  throws NoProperDataException
	{
		customer.setCust_id(service.getSequenceNumberForCustomer(Customer.SEQUENCE_NAME));
		return feigncustomer.addCustomer(customer);
	}


	@DeleteMapping(path="/customers/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteCustomer(@Valid @PathVariable int id) throws CustomerNotFoundException {
			return feigncustomer.deleteCustomer(id);
	}

}
