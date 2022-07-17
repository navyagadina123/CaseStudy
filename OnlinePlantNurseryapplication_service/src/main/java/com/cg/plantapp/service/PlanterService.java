package com.cg.plantapp.service;

import java.util.List;

import com.cg.plantapp.exception.NoProperDataException;
import com.cg.plantapp.exception.PlanterNotFoundException;
import com.cg.plantapp.model.Planter;

public interface PlanterService {
	public  List<Planter> getAllPlanters() throws  PlanterNotFoundException;
	public Planter getPlanterById( int id) throws PlanterNotFoundException;
	public Planter addPlanter( Planter planter)  throws NoProperDataException;
	public String deletePlanter(Integer id) throws PlanterNotFoundException;
}
