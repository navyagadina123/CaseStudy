package com.cg.plantapp.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@NotNull
	private	String commonName;
	
	@NotBlank(message="typeofplant")
	@Size(max=20)
	private String typeOfPlant;
	
	@NotBlank(message="plantDescription")
	@Size(max=40)
	private String plantDescription;
	
	@NotBlank(message="plantstock")
	@Size(min=30)
	private Integer plantsStock;
	
	@NotBlank(message="cost")
	@Size(min=10)
	private	double cost;

}
