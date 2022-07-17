package com.cg.plantapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.plantapp.exception.NoProperDataException;
import com.cg.plantapp.exception.PlanterNotFoundException;
import com.cg.plantapp.model.Planter;
import com.cg.plantapp.repository.PlanterRepository;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class PlanterServiceImpl implements PlanterService {
	@Autowired
	private PlanterRepository planterRepository;
	
	
	@Override
	public List<Planter> getAllPlanters() throws PlanterNotFoundException {
		log.info("get all planters from here");
		return planterRepository.findAll();
	}

	
	@Override
	public Planter addPlanter( Planter planter) throws NoProperDataException {
		log.info("start");
		if(planter!=null) 
		{
			planterRepository.save(planter);
			log.debug("added plant");
		}
		else
		{
			throw new NoProperDataException("Please fill fields");
		}
		return planter;
	}
	

	
	@Override
	public Planter getPlanterById(int id) throws PlanterNotFoundException {
		Planter planters=planterRepository.findById(id).orElseThrow(()-> new  PlanterNotFoundException("planter Not Found"+id));

		return planters;
	}

	
	




	@Override
	public String deletePlanter(@PathVariable Integer id) throws PlanterNotFoundException{
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
		return " deleted successfully";
	}

}

