package com.cg.opna.planter.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
		@NotNull(message="enter planterHeight")
		float planterHeight;
		@NotBlank(message="enter planterColor")
		String planterColor;
		@NotBlank(message="enter planterShape")
		String planterShape;
		@NotNull(message="enter planterStock")
		int planterStock;
		@NotNull(message="enter planterCost")
		int planterCost;
	}


