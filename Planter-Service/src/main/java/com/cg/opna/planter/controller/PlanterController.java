package com.cg.opna.planter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.opna.planter.exception.NoProperDataException;
import com.cg.opna.planter.exception.PlanterNotFoundException;
import com.cg.opna.planter.model.Planter;
import com.cg.opna.planter.service.PlanterServiceImpl;
import com.cg.opna.planter.service.SequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/planter")
@Slf4j
public class PlanterController {
	@Autowired
	private PlanterServiceImpl planterServiceimpl;

	@Autowired
	private SequenceGeneratorService service;

	
	@GetMapping("/allplanters") 
	public ResponseEntity<List<Planter>> getAllPlanters() throws PlanterNotFoundException
	{
		List<Planter> planters=planterServiceimpl.getAllPlanters();
		log.info("starting  of get mapping");
	
		if(planters.size()>0) {
			log.debug("planters are {}"
					+ planters);
		 return new  ResponseEntity<>(planters,HttpStatus.OK); 
		}
		else {
			log.debug(" no planters found ");
			 return new  ResponseEntity<>(planters,HttpStatus.NO_CONTENT); 
		}
		
	}
	
	@GetMapping("/planters/{id}")
	public ResponseEntity<Planter> getPlanterById(@PathVariable  Integer id)
	throws PlanterNotFoundException{
		Planter planters= planterServiceimpl.getPlanterById(id);
		  return ResponseEntity.ok().body(planters);

	}
	
	@PostMapping("/addplanters") 
	public ResponseEntity<Planter> addPlanter(@RequestBody Planter pdto)  throws NoProperDataException
	{
		
		if(pdto!=null) 
		{
			
			pdto.setPlanterId(service.getSequenceNumberForPlanter(Planter.SEQUENCE_NAME));
			planterServiceimpl.addPlanter(pdto);
			log.error("added planter");
			return new ResponseEntity<>(pdto,HttpStatus.CREATED);
			
		}
		else
		{
			throw new NoProperDataException("Please fill fields");
			
		}
		
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
				throw new PlanterNotFoundException("Planter with the id "+id+" doesn't exist");
				//log.error(e.getMessage());
			}
			}
			else
			{
				//throw new PlanterNotFoundException("Planter with the id "+id+" doesn't exist");
				log.info("id not found");
			}
			
		}
		
		
			return ResponseEntity.ok(" deleted operation done ");
	
	}
	


@PutMapping("/updateplanter")
public String updatePlanter(@RequestBody Planter planter) throws PlanterNotFoundException{
	String pltr=planterServiceimpl.updatePlanter(planter);
	return pltr;
}

}
	
	


