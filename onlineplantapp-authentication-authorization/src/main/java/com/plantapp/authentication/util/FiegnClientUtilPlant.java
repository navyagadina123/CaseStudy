package com.plantapp.authentication.util;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.plantapp.authentication.models.Plant;

@FeignClient(value ="PlantNursery-Service",url ="http://localhost:8081/plant")
public  interface FiegnClientUtilPlant {
	

	@GetMapping("/allplants") 
	@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
	public ResponseEntity<List<Plant>> getAllPlants();
	
	
	@GetMapping("/plants/{id}")
	@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
	public ResponseEntity<Plant> getPlantById(Integer id);
	
	
	@PostMapping("/addplants") 
	@PreAuthorize(" hasRole('ADMIN')")
	public ResponseEntity<Plant> addPlant(Plant plant); 

	@PutMapping("/updateplant/{id}")
	public ResponseEntity<Plant> updatePlant(@RequestBody Plant plant,@PathVariable Integer id);
	
	@DeleteMapping(path="/plants/{id}")
	@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
	public ResponseEntity<String> deletePlant(Integer id);

	
}
