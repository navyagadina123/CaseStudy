package com.plantapp.authentication.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="plant_details")
public class Plant {
		
		public static final String SEQUENCE_NAME = "plant_sequence";
	@Id
	private	int plant_Id;
	private	String commonName;
	private String typeOfPlant;
	private String plantDescription;
	private int plantsStock;
	private	double cost;

}
