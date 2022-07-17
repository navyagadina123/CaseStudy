package com.plantapp.authentication.util;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.plantapp.authentication.models.Customer;


@FeignClient(value="Customer-Service",url="http://localhost:8086/api/v2")
public interface FiegnClientUtilCustomer {
	
	@GetMapping("/allcustomers") 
	public ResponseEntity<List<Customer>> getAllCustomer();
	
	
	@GetMapping("/customers/{id}")
	
	public ResponseEntity<Customer> getCustomerById(int id);
	
	
	@PostMapping("/addCustomers") 
	public ResponseEntity<Customer> addCustomer(Customer customer);

	
	
	@DeleteMapping(path="/customers/{id}")
	public ResponseEntity<String> deleteCustomer(int id);


}
