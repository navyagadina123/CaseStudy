package com.cg.plantapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.plantapp.model.Planter;

public interface PlanterRepository extends MongoRepository<Planter, Integer>{

}
