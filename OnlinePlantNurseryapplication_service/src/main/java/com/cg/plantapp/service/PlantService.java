package com.cg.plantapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.plantapp.entity.Plant;
import com.cg.plantapp.exception.NoProperDataException;
import com.cg.plantapp.exception.PlantNotFoundException;


public interface PlantService {

	public  ResponseEntity<List<Plant>> getAllPlants() throws  PlantNotFoundException;
	public ResponseEntity<Plant> getPlantById(@PathVariable int id) throws PlantNotFoundException;
	public ResponseEntity<Plant> addPlant(@RequestBody Plant plant)  throws NoProperDataException;
	public ResponseEntity<Plant> updatePlant(@RequestBody Plant plant ,@PathVariable int id)  throws PlantNotFoundException;
	public ResponseEntity<String> deletePlant(@PathVariable Integer id) throws PlantNotFoundException;
}
