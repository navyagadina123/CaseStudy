package com.cg.opna.order;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import javax.ws.rs.core.Response;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import com.cg.opna.order.model.Order;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class OrderServiceApplicationTests {
//
//	private MockMvc mockMvc;
//	
//	@Autowired
//	private WebApplicationContext context;
//	
//	ObjectMapper om=new ObjectMapper();
//	@Before
//	public void setUp() {
//		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
//		
//	}	@Test
//	public void addOrdersTest() throws Exception {
//		Order order=new Order();
//		order.setBookingOrderId(600);
////		order.setOrderDate();
//		order.setQuantity(4);
//		order.setTotalCost(40);
//		order.setTransactionMode("online");
//		
//		String jsonRequest= om.writeValueAsString(order);
//		MvcResult result = mockMvc.perform(
//				post("/api/v3/addorders").content(jsonRequest).content(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
//		String resultContent=result.getResponse().getContentAsString();
//		
//		Response  response=om.readValue(resultContent,Response.class);
//		Assert.assertTrue(response.isStatus()== Boolean.TRUE);
//		
//	}
//	@Test
//	public void getOrdersTest() throws Exception {
//		
//		MvcResult result = mockMvc
//				.perform(get("/api/v3/getorders").content(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
//		String resultContent=result.getResponse().getContentAsString();
//		
//		Response response=om.readValue(resultContent,Response.class);
//		Assert.assertTrue(response.isStatus()== Boolean.TRUE);
//}
}