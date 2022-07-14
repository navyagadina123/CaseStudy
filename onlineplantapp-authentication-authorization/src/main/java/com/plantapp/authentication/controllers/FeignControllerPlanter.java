package com.plantapp.authentication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plantapp.authentication.exception.NoProperDataException;
import com.plantapp.authentication.exception.PlanterNotFoundException;
import com.plantapp.authentication.models.Planter;
import com.plantapp.authentication.services.SequenceGeneratorService;
import com.plantapp.authentication.util.FeignClientUtilPlanter;


@RestController
@RequestMapping("/planter")
public class FeignControllerPlanter  {
	
	@Autowired
	private FeignClientUtilPlanter feignplanter;
	
	
	@Autowired
	private SequenceGeneratorService service;
	
	@GetMapping("/allplanters") 
	public ResponseEntity<List<Planter>> getAllPlanters() throws PlanterNotFoundException
	{
		
		return feignplanter.getAllPlanters();
		
	}
	
	@GetMapping("/planters/{id}")
	public ResponseEntity<Planter> getPlanterById(@PathVariable  Integer id)
	throws PlanterNotFoundException{
		return feignplanter.getPlanterById(id);
	}
	
	@PostMapping("/addplanters") 
	public ResponseEntity<Planter> addPlanter(@RequestBody Planter planter)  throws NoProperDataException
	{
		
		planter.setPlanter_Id(service.getSequenceNumberForPlanter(Planter.SEQUENCE_NAME));
		return feignplanter.addPlanter(planter);
	}


	@DeleteMapping(path="/planters/{id}")
	public ResponseEntity<String> deletePlanter(@PathVariable int id) throws PlanterNotFoundException {
			return feignplanter.deletePlanter(id);
	}

}
