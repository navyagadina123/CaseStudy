package com.cg.plantapp.model;

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
	private	Integer plantId;
	private	String commonName;
	private String typeOfPlant;
	private String plantDescription;
	private Integer plantsStock;
	private	double cost;

}
