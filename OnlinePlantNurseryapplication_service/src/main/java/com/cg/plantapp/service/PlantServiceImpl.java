package com.cg.plantapp.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.plantapp.entity.Plant;
import com.cg.plantapp.exception.NoProperDataException;
import com.cg.plantapp.exception.PlantNotFoundException;
import com.cg.plantapp.repository.PlantRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PlantServiceImpl implements PlantService{
	
	@Autowired
	private PlantRepository plantRepository;
	
	
	@Override
	public List<Plant> getAllPlants() throws PlantNotFoundException {
		List<Plant> plants =new ArrayList<>();
		plants =plantRepository.findAll();
		try {
		if(plants.size()==0){
			throw new PlantNotFoundException("Plant is empty");
		}
		}catch(PlantNotFoundException e)
		{
			log.error(e.getMessage());
		}
	return plants;
	}
	
	@Override
	public Plant addPlant(@RequestBody Plant plant) throws NoProperDataException {
		log.info("start");
		if(plant!=null) 
		{
			plantRepository.save(plant);
			System.out.println("plant added");
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
    	plants.setPlant_Id(plants.getPlant_Id());
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


	

	



