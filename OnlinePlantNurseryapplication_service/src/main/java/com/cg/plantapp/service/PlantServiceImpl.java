package com.cg.plantapp.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.plantapp.exception.NoProperDataException;
import com.cg.plantapp.exception.PlantNotFoundException;
import com.cg.plantapp.model.Plant;
import com.cg.plantapp.repository.PlantRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PlantServiceImpl implements PlantService{
	
	@Autowired
	private PlantRepository plantRepository;
	
	
	@Override
	public List<Plant> getAllPlants() throws PlantNotFoundException {
		List<Plant> plts =new ArrayList<>();
		plts =plantRepository.findAll();
		try {
		if(plts.size()==0){
			throw new PlantNotFoundException("Plant is empty");
		}
		}catch(PlantNotFoundException e)
		{
			log.error(e.getMessage());
		}
	return plts;
	}
	
	@Override
	public Plant addPlant(@RequestBody Plant plant) throws NoProperDataException {
		log.info("start");
		if(plant!=null) 
		{
			plantRepository.save(plant);
			log.debug("plant added");
		}
		else
		{
			throw new NoProperDataException("Please fill fields");
		}
		return plant;	
		}
	
		
	
	@Override
	public Plant getPlantById(int id) throws PlantNotFoundException {
		Plant plants=plantRepository.findById(id).orElseThrow(()-> new  PlantNotFoundException("plant Not Found"+id));

		return plants;
	}

	
	@Override
	public Plant updatePlant(Plant plant,Integer id) throws PlantNotFoundException {
		Plant plants=plantRepository.findById(id).orElseThrow(()-> new PlantNotFoundException("plant not "+id));
    	plants.setPlantId(plants.getPlantId());
		plants.setCommonName(plants.getCommonName());
     	plants.setPlantDescription(plants.getPlantDescription());
		plants.setTypeOfPlant(plants.getTypeOfPlant());
		plants.setPlantsStock(plants.getPlantsStock());
		plants.setCost(plants.getCost());
		
		final Plant  updatedPlant = plantRepository.save(plants);
		return updatedPlant;
	}



	@Override
	public String deletePlant(Integer id) throws PlantNotFoundException {
		log.info("Start delete");
		var isRemoved =plantRepository.findById(id);
		if(isRemoved.isPresent())
		{
			plantRepository.deleteById(id);
			log.debug("deleted successfully {}",isRemoved.get());
		}
		else
		{
			throw new PlantNotFoundException("Id Not Available");
		}
		log.info(" deleted End");
		return " deleted successfully";
	}

}


	

	



