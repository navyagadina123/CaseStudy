package com.plantapp.authentication.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customer_details")
public class Customer {
   
	public static final String SEQUENCE_NAME = "customer_sequence";
	@Id
	private int cust_id;
	@NotNull
	private String username;
	@Email
	private String email;
	
	private String contact_No;
	private String address;
}
