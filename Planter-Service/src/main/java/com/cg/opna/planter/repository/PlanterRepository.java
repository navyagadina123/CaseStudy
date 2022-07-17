package com.cg.opna.planter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.opna.planter.model.Planter;

@Repository
public interface PlanterRepository extends MongoRepository<Planter, Integer>{

}
