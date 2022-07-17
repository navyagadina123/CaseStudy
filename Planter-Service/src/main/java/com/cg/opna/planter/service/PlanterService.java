package com.cg.opna.planter.service;

import java.util.List;

import com.cg.opna.planter.exception.NoProperDataException;
import com.cg.opna.planter.exception.PlanterNotFoundException;
import com.cg.opna.planter.model.Planter;


public interface PlanterService {
	public  List<Planter> getAllPlanters() throws  PlanterNotFoundException;
	public Planter getPlanterById( int id) throws PlanterNotFoundException;
	public Planter addPlanter( Planter planter)  throws NoProperDataException;
	public String deletePlanter(Integer id) throws PlanterNotFoundException;
     public String updatePlanter(Planter p) throws PlanterNotFoundException;
}
