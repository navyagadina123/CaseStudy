package com.cg.opna.planter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.opna.planter.exception.NoProperDataException;
import com.cg.opna.planter.exception.PlanterNotFoundException;
import com.cg.opna.planter.model.Planter;
import com.cg.opna.planter.repository.PlanterRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PlanterServiceImpl implements PlanterService {
	
	@Autowired
	private PlanterRepository planterRepository;

	@Override
	public List<Planter> getAllPlanters() throws PlanterNotFoundException {
		
		List<Planter> planters= planterRepository.findAll();
		log.debug("Planters are :{}",planters);
		
		return planters;
		
	}

	@Override
	public Planter getPlanterById(int id) throws PlanterNotFoundException {
		
		log.info("start");
		return planterRepository.findById(id)
				.orElseThrow(()->  new PlanterNotFoundException("Planter with the id "+id+" doesn't exist"));
	}

	@Override
	public Planter addPlanter(Planter planter) throws NoProperDataException {
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
	public String deletePlanter(Integer id) throws PlanterNotFoundException {
		log.info("start");
		Optional<Planter> pop=planterRepository.findById(id);
		
		if(!pop.isPresent()) {
			throw new PlanterNotFoundException("Planter with the id "+id+" doesn't exist");
		}else {
			planterRepository.deleteById(id);
			log.debug(" planter deleted successfully {}",pop.get());
		}
		log.info("End");
		return id+ " planter  deleted successfully....";
	}
	

	@Override
	public String updatePlanter(Planter p) throws PlanterNotFoundException {
		
		Optional<Planter> planters=planterRepository.findById(p.getPlanterId());
		Planter pltr=null;
		if(!planters.isPresent()) {
			log.debug("planter not found");
			throw new PlanterNotFoundException("Planter with the id "+p.getPlanterId()+" doesn't exist for update");
			
		}else {
			pltr=planters.get();
			pltr.setPlanterId(p.getPlanterId());
			pltr.setPlanterColor(p.getPlanterColor());
			pltr.setPlanterCost(p.getPlanterCost());
			pltr.setPlanterHeight(p.getPlanterHeight());
			pltr.setPlanterShape(p.getPlanterShape());
			pltr.setPlanterStock(p.getPlanterStock());
			planterRepository.save(pltr);
			log.debug("updated successfully {}",pltr);
		}
		
		return pltr+ "\n updated successfully....";
	}

	}


