package com.plantapp.authentication.util;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;


import com.plantapp.authentication.models.Planter;


@FeignClient(value="PlantNursery-Service",url="http://localhost:8081/planter")
public interface FeignClientUtilPlanter {
	
	@GetMapping("/allplanters") 
	public ResponseEntity<List<Planter>> getAllPlanters();
	
	@GetMapping("/planters/{id}")
	public ResponseEntity<Planter> getPlanterById(Integer id);
	
	
	@PostMapping("/addplanters") 
	public ResponseEntity<Planter> addPlanter(Planter planter);

	
	@DeleteMapping(path="/planters/{id}")
	public ResponseEntity<String> deletePlanter( int id);



}
