package com.cg.plantapp.serviceimpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.plantapp.entity.Plant;
import com.cg.plantapp.exception.NoProperDataException;
import com.cg.plantapp.exception.PlantNotFoundException;
import com.cg.plantapp.repository.PlantRepository;
import com.cg.plantapp.service.PlantService;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PlantServiceImpl implements PlantService{
	
	@Autowired
	private PlantRepository plantRepository;
	
	
	@Override
	public ResponseEntity<List<Plant>> getAllPlants() throws PlantNotFoundException {
		log.info("get all seeds from here");
		return new  ResponseEntity<>(plantRepository.findAll(),HttpStatus.OK);
	}

	
	@Override
	public ResponseEntity<Plant> addPlant(@RequestBody Plant plant) throws NoProperDataException {
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
		return ResponseEntity.ok(plant);
	}
	

	
	@Override
	public ResponseEntity<Plant> getPlantById(int id) throws PlantNotFoundException {
		Plant plants=plantRepository.findById(id).orElseThrow(()-> new  PlantNotFoundException("plant Not Found"+id));

		return ResponseEntity.ok().body(plants);
	}

	

	@Override
	public ResponseEntity<Plant> updatePlant(Plant plant, int id) throws PlantNotFoundException {
		Plant plants=plantRepository.findById(id).orElseThrow(()-> new PlantNotFoundException("seed not "+id));
		plants.setPlant_Id(plant.getPlant_Id());
		plants.setCommonName(plant.getCommonName());
		plants.setPlantDescription(plant.getPlantDescription());
		plants.setTypeOfPlant(plant.getTypeOfPlant());
		plants.setPlantsStock(plant.getPlantsStock());
		plants.setCost(plant.getCost());
		
		final Plant  updatedPlant = plantRepository.save(plant);
		return ResponseEntity.ok(updatedPlant);
	}


	

	
	

	

	@Override
	public ResponseEntity<String> deletePlant(Integer id) throws PlantNotFoundException {
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
		return ResponseEntity.ok(id+" deleted successfully");
	}

}


	

	



