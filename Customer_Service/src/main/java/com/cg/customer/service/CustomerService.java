package com.cg.customer.service;

import java.util.List;
import com.cg.customer.entity.Customer;
import com.cg.customer.exception.CustomerNotFoundException;
import com.cg.customer.exception.NoProperDataException;


	public interface CustomerService {
		public  List<Customer> getAllCustomers();
		public Customer getCustomerById(int id) throws CustomerNotFoundException;
		public Customer addCustomer( Customer customer) throws NoProperDataException;
		public String deleteCustomer(Integer id) throws CustomerNotFoundException;
	}


