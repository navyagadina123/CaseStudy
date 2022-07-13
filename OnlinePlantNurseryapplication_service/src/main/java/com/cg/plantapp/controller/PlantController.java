package com.cg.plantapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.cg.plantapp.entity.Plant;
import com.cg.plantapp.exception.NoProperDataException;
import com.cg.plantapp.exception.PlantNotFoundException;
import com.cg.plantapp.serviceimpl.PlantServiceImpl;
import com.cg.plantapp.serviceimpl.SequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;
@CrossOrigin(origins="http://localhost:3000/")
@RestController
@Slf4j
@RequestMapping("/api/v1")
public class PlantController {

	@Autowired
	private PlantServiceImpl plantServiceimpl;

	@Autowired
	private SequenceGeneratorService service;
	
	@GetMapping("/allplants") 
	public ResponseEntity<List<Plant>> getAllPlants() throws PlantNotFoundException
	{
		log.info("starting  of get mapping");
		return plantServiceimpl.getAllPlants();
		
	}
	
	@GetMapping("/plants/{id}")
	public ResponseEntity<Plant> getPlantById(@PathVariable  Integer id)
	throws PlantNotFoundException{
		return plantServiceimpl.getPlantById(id);
	}
	
	@PostMapping("/addplants") 
	public ResponseEntity<Plant> addPlant(@RequestBody Plant plant)  throws NoProperDataException
	{
		log.info("start");
		plant.setPlant_Id(service.getSequenceNumberForPlant(Plant.SEQUENCE_NAME));
		return plantServiceimpl.addPlant(plant);
	}

	@PutMapping("/updateplant/{id}")
	public ResponseEntity<Plant> updatePlant(@RequestBody Plant plant,@PathVariable int id) throws PlantNotFoundException
	{
		return plantServiceimpl.updatePlant(plant, id);
	}
	
	@DeleteMapping(path="/plants/{id}")
	public ResponseEntity<String> deletePlant(@PathVariable int id) throws PlantNotFoundException {
			return plantServiceimpl.deletePlant(id);
}

	
	
}
