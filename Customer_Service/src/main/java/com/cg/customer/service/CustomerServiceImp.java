package com.cg.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	public List<Customer> getAllCustomers()  {
		log.info("get all customers");
		return customerRepository.findAll();
		
	}
	
	

	
	@Override
	public Customer addCustomer(Customer customer) throws NoProperDataException {
		
		if(customer!=null) 
		{
			customerRepository.save(customer);
			log.debug("customer added {}",customer);
			
		}
		else
		{
			throw new NoProperDataException("Please fill fields");
		}
		return customer;
	}
	

	
	@Override
	public Customer getCustomerById(int id) throws CustomerNotFoundException {
		Customer customers=customerRepository.findById(id).orElseThrow(()-> new  CustomerNotFoundException("customer Not Found"+id));
		log.debug("customers getbyid {}",customers);
		return customers;
	}

	



	@Override
	public String deleteCustomer(Integer id) throws CustomerNotFoundException {
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
		return " deleted successfully";
	}

}
