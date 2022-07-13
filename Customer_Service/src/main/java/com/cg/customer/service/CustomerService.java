package com.cg.customer.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.customer.entity.Customer;
import com.cg.customer.exception.CustomerNotFoundException;
import com.cg.customer.exception.NoProperDataException;

	public interface CustomerService {
		public  ResponseEntity<List<Customer>> getAllCustomers() throws  CustomerNotFoundException;
		public ResponseEntity<Customer> getCustomerById(@PathVariable int id) throws CustomerNotFoundException;
		public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)  throws NoProperDataException;
		public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer ,@PathVariable int id)  throws CustomerNotFoundException;
		public ResponseEntity<String> deleteCustomer(@PathVariable Integer id) throws CustomerNotFoundException;
	}


