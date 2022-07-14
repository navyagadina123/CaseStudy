package com.cg.plantapp.service;

import java.util.List;
import com.cg.plantapp.entity.Plant;
import com.cg.plantapp.exception.NoProperDataException;
import com.cg.plantapp.exception.PlantNotFoundException;

public interface PlantService {

	public  List<Plant> getAllPlants() throws  PlantNotFoundException;
	public Plant getPlantById( int id) throws PlantNotFoundException;
	public Plant addPlant( Plant plant)  throws  NoProperDataException;
	public Plant updatePlant(Plant plant,Integer id)  throws PlantNotFoundException;
	public String deletePlant( Integer id) throws PlantNotFoundException;
}
