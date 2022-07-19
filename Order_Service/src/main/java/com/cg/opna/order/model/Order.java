package com.cg.opna.order.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Document(collection="order")
	public class Order {
		
		public static final String SEQUENCE_NAME = "order_sequence";
		@Id
	    private int bookingOrderId;
		
	   private LocalDate orderDate;
	   @NotBlank(message="enter valid transactionMode")
	    private String transactionMode;
	   @NotBlank(message="enter valid quantity")
		private int quantity;
	   @NotBlank(message="enter valid totalCost")
		double totalCost;
}
