package com.cg.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.customer.entity.Customer;
import com.cg.customer.exception.CustomerNotFoundException;
import com.cg.customer.exception.NoProperDataException;
import com.cg.customer.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImp implements CustomerService {

	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Override
	public ResponseEntity<List<Customer>> getAllCustomers() throws CustomerNotFoundException {
		log.info("get all customers from here");
		return new  ResponseEntity<>(customerRepository.findAll(),HttpStatus.OK);
	}

	
	@Override
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws NoProperDataException {
		log.info("start");
		if(customer!=null) 
		{
			customerRepository.save(customer);
			System.out.println("customer added");
		}
		else
		{
			throw new NoProperDataException("Please fill fields");
		}
		return ResponseEntity.ok(customer);
	}
	

	
	@Override
	public ResponseEntity<Customer> getCustomerById(int id) throws CustomerNotFoundException {
		Customer customers=customerRepository.findById(id).orElseThrow(()-> new  CustomerNotFoundException("customer Not Found"+id));

		return ResponseEntity.ok().body(customers);
	}

	@Override
	public ResponseEntity<Customer> updateCustomer(Customer customer, int id) throws CustomerNotFoundException {
		Customer customers=customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException("customer not "+id));
		
		customers.setUsername(customer.getUsername());
		customers.setAddress(customer.getAddress());
		customers.setEmail(customer.getEmail());
		customers.setContact_No(customer.getContact_No());
		
		
		final Customer updatedCustomer = customerRepository.save(customer);
		return ResponseEntity.ok(updatedCustomer);
	}

	@Override
	public ResponseEntity<String> deleteCustomer(Integer id) throws CustomerNotFoundException {
		log.info("Start delete");
		var isRemoved =customerRepository.findById(id);
		if(isRemoved.isPresent())
		{
			customerRepository.deleteById(id);
			log.debug("deleted successfully {}",isRemoved.get());
		}
		else
		{
			throw new CustomerNotFoundException("Id Not Available");
		}
		log.info(" deleted End");
		return ResponseEntity.ok(id+" deleted successfully");
	}

}
