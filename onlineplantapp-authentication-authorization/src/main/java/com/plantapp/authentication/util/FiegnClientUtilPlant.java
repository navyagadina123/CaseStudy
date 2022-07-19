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
import org.springframework.web.bind.annotation.RequestHeader;

import com.plantapp.authentication.models.Plant;

@FeignClient(value ="PlantNursery-Service",url ="http://localhost:8081/plant")
public  interface FiegnClientUtilPlant {
	

	@GetMapping("/allplants") 
	public ResponseEntity<List<Plant>> getAllPlants(@RequestHeader("Authorization") String token);
	
	
	@GetMapping("/plants/{id}")
	public ResponseEntity<Plant> getPlantById(@RequestHeader("Authorization") String token,Integer id);
	
	
	@PostMapping("/addplants") 
	@PreAuthorize(" hasRole('ADMIN')")
	public ResponseEntity<Plant> addPlant(Plant plant); 

	@PutMapping("/updateplant/{id}")
	public ResponseEntity<Plant> updatePlant(@RequestBody Plant plant,@PathVariable Integer id);
	
	@DeleteMapping(path="/plants/{id}")
	
	public ResponseEntity<String> deletePlant(@RequestHeader("Authorization") String token,Integer id);

	
}
