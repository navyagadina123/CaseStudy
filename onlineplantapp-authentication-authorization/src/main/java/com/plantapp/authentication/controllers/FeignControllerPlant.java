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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plantapp.authentication.exception.NoProperDataException;
import com.plantapp.authentication.exception.PlantNotFoundException;
import com.plantapp.authentication.models.Plant;
import com.plantapp.authentication.services.SequenceGeneratorService;
import com.plantapp.authentication.util.FiegnClientUtilPlant;

@RestController
@RequestMapping("/plant")
public class FeignControllerPlant {

	@Autowired
	private FiegnClientUtilPlant feignplant;
	
	
	@Autowired
	private SequenceGeneratorService service;

	@GetMapping("/allplants") 
	@PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
	public ResponseEntity<List<Plant>> getAllPlants(@RequestHeader("Authorization") String token) throws PlantNotFoundException
	{
		
		return feignplant.getAllPlants(token);
		
	}
	
	@GetMapping("/plants/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<Plant> getPlantById(@Valid@RequestHeader("Authorization") String token, @PathVariable  Integer id)
	throws PlantNotFoundException{
		return feignplant.getPlantById(token,id);
	}
	
	@PostMapping("/addplants") 
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Plant> addPlant(@RequestBody Plant plant)  throws NoProperDataException
	{
		plant.setPlant_Id(service.getSequenceNumberForPlant(Plant.SEQUENCE_NAME));
		
		return feignplant.addPlant(plant);
	}

	@PutMapping("/updateplant/{id}")
	@PreAuthorize( "hasRole('ADMIN')")
	public ResponseEntity<Plant> updatePlant( @RequestBody Plant plant,@PathVariable Integer id) throws PlantNotFoundException
	{
	return feignplant.updatePlant(plant, id);
	}
	
	@DeleteMapping(path="/plants/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<String> deletePlant(@Valid @RequestHeader("Authorization") String token,@PathVariable Integer id) throws PlantNotFoundException {
			return feignplant.deletePlant(token,id);
}

	
}
