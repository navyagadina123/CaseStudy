package com.cg.opna.planter.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection="planter_details")

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
	public class Planter {
		public static final String SEQUENCE_NAME = "planter_sequence";
		@Id
		Integer planterId;
		@NotBlank
		float planterHeight;
		String planterColor;
		String planterShape;
		int planterStock;
		int planterCost;
	}


