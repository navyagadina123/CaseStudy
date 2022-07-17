package com.cg.plantapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.plantapp.exception.NoProperDataException;
import com.cg.plantapp.exception.PlanterNotFoundException;
import com.cg.plantapp.model.Planter;
import com.cg.plantapp.service.PlanterServiceImpl;
import com.cg.plantapp.service.SequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/planter")
public class PlanterController {

	@Autowired
	private PlanterServiceImpl planterServiceimpl;

	@Autowired
	private SequenceGeneratorService service;

	
	@GetMapping("/allplanters") 
	public ResponseEntity<List<Planter>> getAllPlanters() throws PlanterNotFoundException
	{
		log.info("starting  of get mapping");
		return new  ResponseEntity<>(planterServiceimpl.getAllPlanters(),HttpStatus.OK);
		
	}
	
	@GetMapping("/planters/{id}")
	public ResponseEntity<Planter> getPlanterById(@PathVariable  Integer id)
	throws PlanterNotFoundException{
		Planter planters= planterServiceimpl.getPlanterById(id);
		  return ResponseEntity.ok().body(planters);

	}
	
	@PostMapping("/addplanters") 
	public ResponseEntity<Planter> addPlanter(@RequestBody Planter pltr)  throws NoProperDataException
	{
		log.info("start");
		pltr.setPlanterId(service.getSequenceNumberForPlanter(Planter.SEQUENCE_NAME));
		return new ResponseEntity<>(planterServiceimpl.addPlanter(pltr),HttpStatus.CREATED);
	}


	
	@DeleteMapping(path="/planters/{id}")
	public ResponseEntity<String> deletePlanter(@PathVariable int id) throws PlanterNotFoundException {
		int count=1;
		for(int i=1;i>=count;count++)
		{
			if(count==1)
			{
			try {
				planterServiceimpl.deletePlanter(id);
			} catch (PlanterNotFoundException e) {
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
	}



