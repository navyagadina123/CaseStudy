package com.cg.plantapp.service;

import java.util.List;
import com.cg.plantapp.entity.Planter;
import com.cg.plantapp.exception.NoProperDataException;
import com.cg.plantapp.exception.PlanterNotFoundException;

public interface PlanterService {
	public  List<Planter> getAllPlanters() throws  PlanterNotFoundException;
	public Planter getPlanterById( int id) throws PlanterNotFoundException;
	public Planter addPlanter( Planter planter)  throws NoProperDataException;
	public String deletePlanter(Integer id) throws PlanterNotFoundException;
}
