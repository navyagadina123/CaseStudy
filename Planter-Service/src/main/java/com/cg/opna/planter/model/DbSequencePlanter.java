package com.cg.opna.planter.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "db_sequence_planter")
//@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
	public class DbSequencePlanter {
	    @Id
	    private String  id;
	    private int seq;
	
}

