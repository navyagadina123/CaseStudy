package com.cg.plantapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.plantapp.model.Plant;

@Repository
public interface PlantRepository extends MongoRepository<Plant, Integer>{

}


