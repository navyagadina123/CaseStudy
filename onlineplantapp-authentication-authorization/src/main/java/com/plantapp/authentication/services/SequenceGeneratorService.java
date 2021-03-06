package com.plantapp.authentication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.plantapp.authentication.models.DbSequenceCustomer;
import com.plantapp.authentication.models.DbSequenceOrder;
import com.plantapp.authentication.models.DbSequencePlanter;
import com.plantapp.authentication.models.DbSequencePlant;

import java.util.Objects;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class SequenceGeneratorService {

	    @Autowired
	    private MongoOperations mongoOperations;


    public int getSequenceNumberForPlant(String sequenceName) {
        
        Query query = new Query(Criteria.where("id").is(sequenceName));
	        //update the sequence no/	      
        Update update = new Update().inc("seq",500);
        DbSequencePlant counter = mongoOperations
	                .findAndModify(query,
                         update, options().returnNew(true).upsert(true),
                        DbSequencePlant.class);
	        return !Objects.isNull(counter) ? counter.getSeq() :1;
	    }

	    public int getSequenceNumberForOrder(String sequenceName) {
	        //get sequence no
	        Query query = new Query(Criteria.where("id").is(sequenceName));
	        //update the sequence no
	        Update update = new Update().inc("seq",500);
	      
	        DbSequenceOrder counter = mongoOperations
	                .findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        DbSequenceOrder.class);

	        return !Objects.isNull(counter) ? counter.getSeq() :1;
	    }
	    
	    
	    
	    
	    public int getSequenceNumberForPlanter(String sequenceName) {
	        //get sequence no
	        Query query = new Query(Criteria.where("id").is(sequenceName));
	        //update the sequence no
	        Update update = new Update().inc("seq",2000);
	        //modify in document
	        //planter id will start from 100
	        DbSequencePlanter counter = mongoOperations
	                .findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        DbSequencePlanter.class);

	        return !Objects.isNull(counter) ? counter.getSeq() :1;
	    }
	    
	    
	    public int getSequenceNumberForCustomer(String sequenceName) {
	        //get sequence no
	        Query query = new Query(Criteria.where("id").is(sequenceName));
	        //update the sequence no
	        Update update = new Update().inc("seq",100);
	        //modify in document
	        //customer id will start from 200
	        DbSequenceCustomer counter = mongoOperations
	                .findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        DbSequenceCustomer.class);

	        return !Objects.isNull(counter) ? counter.getSeq() :1;
	    }
	    
	}

