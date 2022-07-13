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
import com.cg.plantapp.entity.Planter;
import com.cg.plantapp.exception.NoProperDataException;
import com.cg.plantapp.exception.PlanterNotFoundException;
import com.cg.plantapp.serviceimpl.PlanterServiceImpl;
import com.cg.plantapp.serviceimpl.SequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class PlanterController {

	@Autowired
	private PlanterServiceImpl planterServiceimpl;

	@Autowired
	private SequenceGeneratorService service;
	
	@GetMapping("/allplanters") 
	public ResponseEntity<List<Planter>> getAllPlanters() throws PlanterNotFoundException
	{
		log.info("starting  of get mapping");
		return planterServiceimpl.getAllPlanters();
		
	}
	
	@GetMapping("/planters/{id}")
	public ResponseEntity<Planter> getPlanterById(@PathVariable  Integer id)
	throws PlanterNotFoundException{
		return planterServiceimpl.getPlanterById(id);
	}
	
	@PostMapping("/addplanters") 
	public ResponseEntity<Planter> addPlanter(@RequestBody Planter planter)  throws NoProperDataException
	{
		log.info("start");
		planter.setPlanter_Id(service.getSequenceNumberForPlanter(Planter.SEQUENCE_NAME));
		return planterServiceimpl.addPlanter(planter);
	}

	@PutMapping("/updateplanter/{id}")
	public ResponseEntity<Planter> updatePlant(@RequestBody Planter planter, @PathVariable int id) throws PlanterNotFoundException
	{
		return planterServiceimpl.updatePlanter(planter, id);
	}
	
	@DeleteMapping(path="/planters/{id}")
	public ResponseEntity<String> deletePlanter(@PathVariable int id) throws PlanterNotFoundException {
			return planterServiceimpl.deletePlanter(id);
	}


}
