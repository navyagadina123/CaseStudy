package com.cg.plantapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.plantapp.exception.NoProperDataException;
import com.cg.plantapp.exception.PlantNotFoundException;
import com.cg.plantapp.model.Plant;
import com.cg.plantapp.service.PlantServiceImpl;
import com.cg.plantapp.service.SequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/plant")
public class PlantController {

	@Autowired
	private PlantServiceImpl plantServiceimpl;

	@Autowired
	private SequenceGeneratorService service;
	
	@GetMapping("/allplants") 
	public ResponseEntity<List<Plant>> getAllPlants() throws PlantNotFoundException
	{
		
		List<Plant> plants=plantServiceimpl.getAllPlants();
		log.info("starting  of get mapping");
	
		if(plants.size()>0) {
			log.debug("plants are {}"
					+ plants);
		 return new  ResponseEntity<>(plants,HttpStatus.OK); 
		}
		else {
			log.debug(" no plants found ");
			 return new  ResponseEntity<>(plants,HttpStatus.NO_CONTENT); 
		}
		
		
	}
	
	@GetMapping("/plants/{id}")
	public ResponseEntity<Plant> getPlantById(@PathVariable  Integer id)
	throws PlantNotFoundException{
		
		Plant plants= plantServiceimpl.getPlantById(id);
		if(plants!=null){
		  return ResponseEntity.ok().body(plants);
		}
		  else {
			return new   ResponseEntity(plants,HttpStatus.NOT_FOUND);
		  }

	}
		
	
	@PostMapping("/addplants") 
	public ResponseEntity<Plant> addPlant(@RequestBody Plant plants)  throws NoProperDataException
		
		{
			
			if(plants!=null) 
			{
				
				plants.setPlantId(service.getSequenceNumberForPlant(Plant.SEQUENCE_NAME));
				plantServiceimpl.addPlant(plants);
				log.error("added planter");
				return new ResponseEntity<>(plants,HttpStatus.CREATED);
				
			}
			else
			{
				throw new NoProperDataException("Please fill fields");
				
			}
			
		}

		


	@DeleteMapping(path="/plants/{id}")
	public ResponseEntity<String> deletePlant(@PathVariable Integer id) throws PlantNotFoundException {
		int count=1;
		for(int i=1;i>=count;count++)
		{
			if(count==1)
			{
			try {
				plantServiceimpl.deletePlant(id);
			} catch (PlantNotFoundException e) {
				log.error(e.getMessage());
			}
			}
			else
			{
				log.info("id not found");
			}
		}
			return ResponseEntity.ok(" deleted operation done ");
	
	}


@PutMapping("/updatePlant/{id}")
public Plant updatePlant(@RequestBody Plant plnts,@PathVariable Integer id) throws PlantNotFoundException {
	Plant plt = plantServiceimpl.updatePlant(plnts, id);
	return plt;
}
	
}

