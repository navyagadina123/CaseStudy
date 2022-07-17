package com.cg.plantapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="planter_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Planter {
	public static final String SEQUENCE_NAME = "planter_sequence";
	@Id
	Integer planterId;
	float planterHeight;
	String planterColor;
	String planterShape;
	int planterStock;
	int planterCost;
}