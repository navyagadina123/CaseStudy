package com.cg.plantapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.plantapp.entity.Planter;
import com.cg.plantapp.exception.NoProperDataException;
import com.cg.plantapp.exception.PlanterNotFoundException;
import com.cg.plantapp.repository.PlanterRepository;
import com.cg.plantapp.service.PlanterService;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class PlanterServiceImpl implements PlanterService {
	@Autowired
	private PlanterRepository planterRepository;
	
	
	@Override
	public ResponseEntity<List<Planter>> getAllPlanters() throws PlanterNotFoundException {
		log.info("get all planters from here");
		return new  ResponseEntity<>(planterRepository.findAll(),HttpStatus.OK);
	}

	
	@Override
	public ResponseEntity<Planter> addPlanter(@RequestBody Planter planter) throws NoProperDataException {
		log.info("start");
		if(planter!=null) 
		{
			planterRepository.save(planter);
			System.out.println("planter added");
		}
		else
		{
			throw new NoProperDataException("Please fill fields");
		}
		return ResponseEntity.ok(planter);
	}
	

	
	@Override
	public ResponseEntity<Planter> getPlanterById(int id) throws PlanterNotFoundException {
		Planter planters=planterRepository.findById(id).orElseThrow(()-> new  PlanterNotFoundException("planter Not Found"+id));

		return ResponseEntity.ok().body(planters);
	}

	@Override
	public ResponseEntity<Planter> updatePlanter(Planter planter, int id) throws PlanterNotFoundException {
		Planter planters=planterRepository.findById(id).orElseThrow(()-> new PlanterNotFoundException("seed not "+id));
		planters.setPlanter_Id(planter.getPlanter_Id());
		planters.setPlanterColor(planter.getPlanterColor());
		planters.setPlanterHeight(planter.getPlanterHeight());
		planters.setPlanterCost(planter.getPlanterCost());
		planters.setPlanterShape(planter.getPlanterShape());
		planters.setPlanterStock(planter.getPlanterStock());
		
		final Planter  updatedPlanter = planterRepository.save(planter);
		return ResponseEntity.ok(updatedPlanter);
	}




	@Override
	public ResponseEntity<String> deletePlanter(@PathVariable Integer id) throws PlanterNotFoundException{
		log.info("Start delete");
		var isRemoved =planterRepository.findById(id);
		if(isRemoved.isPresent())
		{
			planterRepository.deleteById(id);
			log.debug("deleted successfully {}",isRemoved.get());
		}
		else
		{
			throw new PlanterNotFoundException("Id Not Available");
		}
		log.info(" deleted End");
		return ResponseEntity.ok(id+" deleted successfully");
	}

}

