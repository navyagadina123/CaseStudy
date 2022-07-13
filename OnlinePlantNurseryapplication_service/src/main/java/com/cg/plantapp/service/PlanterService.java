package com.cg.plantapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.plantapp.entity.Planter;
import com.cg.plantapp.exception.NoProperDataException;
import com.cg.plantapp.exception.PlanterNotFoundException;

public interface PlanterService {
	public  ResponseEntity<List<Planter>> getAllPlanters() throws  PlanterNotFoundException;
	public ResponseEntity<Planter> getPlanterById(@PathVariable int id) throws PlanterNotFoundException;
	public ResponseEntity<Planter> addPlanter(@RequestBody Planter planter)  throws NoProperDataException;
	public ResponseEntity<Planter> updatePlanter(@RequestBody Planter planter ,@PathVariable int id)  throws PlanterNotFoundException;
	public ResponseEntity<String> deletePlanter(@PathVariable Integer id) throws PlanterNotFoundException;
}
