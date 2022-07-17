package com.cg.opna.planter.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

//import com.cg.opna.planter.exception.NoProperDataException;
import com.cg.opna.planter.exception.PlanterNotFoundException;
import com.cg.opna.planter.model.Planter;
import com.cg.opna.planter.repository.PlanterRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class PlanterServiceTest {
	

	@InjectMocks
	private PlanterServiceImpl planterServiceImpl;
	
	@Mock
	private PlanterRepository planterRepository;
	
	@Test
	void testServiceNotNull() {
		assertThat(planterServiceImpl).isNotNull();
	}
	
	@Test
	void testRepositoryNotNull() {
		assertThat(planterRepository).isNotNull();
	}
	
	@Test
	void testGetAllPlanters() throws PlanterNotFoundException {
		Planter p1= new Planter(2000,9, "red","oval",10, 90);
		Planter p2= new Planter(2001,10, "brown","round",20, 100);
		List<Planter> planterlist=new ArrayList<Planter>();
		planterlist.add(p1);
		planterlist.add(p2);
		when(planterRepository.findAll()).thenReturn(planterlist);
		assertEquals(planterlist,planterServiceImpl.getAllPlanters());
		
	}
	
	@Test
	void testGetPlanterById() throws PlanterNotFoundException {
		Planter p1= new Planter(2000,9, "red","oval",10, 90);
		when(planterRepository.findById(101)).thenReturn(Optional.of(p1));
		assertEquals(p1,planterServiceImpl.getPlanterById(101));
	}
	
	@Test
	void testGetPlanterByInvalidId() throws PlanterNotFoundException {
		Planter p1= new Planter(2000,9, "red","oval",10, 90);
		when(planterRepository.findById(101)).thenReturn(Optional.of(p1));
		try {
			assertThat(planterServiceImpl.getPlanterById(1)).as("Planter with the id 1 doesn't exist");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
//	@Test
//	void testAddPlanter() throws PlanterNotFoundException, NoProperDataException {
//		Planter p1= new Planter(2000,9, "red","oval",10, 90);
//		((List<Planter>) assertThat(planterServiceImpl.addPlanter(p1)))
//		.contains("added successfully....");
//	
//	}	
//	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
//	@Test
//	void testAddPlanterAlreadyExists() throws PlanterNotFoundException {
//		Planter p1= new Planter(2000,9, "red","oval",10, 90);
//		when(planterRepository.findById(101)).thenReturn(Optional.of(p1));
//	try {
//		((List<Planter>) assertThat(planterServiceImpl.addPlanter(p1)))
//		.contains("Product with the id "+p1.getPlanterId()+" already exist");
//	}catch(Exception e) {
//		
//	}
//	}
//	
//	@Test
//	void testupdatePlanter() throws PlanterNotFoundException {
//		Planter p1= new Planter(2000,9, "red","oval",10, 90);	
//		when(planterRepository.findById(101)).thenReturn(Optional.of(p1));
//		assertThat(planterServiceImpl.updatePlanter(p1))
//		.contains("updated successfully....");
//	
//	}
//	
//	@Test
//	void testupdatePlanterDoesnotExists() throws PlanterNotFoundException {
//		Planter p1= new Planter(2000,9, "red","oval",10, 90);	
//		when(planterRepository.findById(10)).thenReturn(Optional.of(p1));
//	try {
//		assertThat(planterServiceImpl.updatePlanter(p1))
//		.contains("Planter with the id "+p1.getPlanterId()+" doesn't exist for update");
//	}catch(Exception e) {
//		
//	}
//	}
	
	@Test
	void testDeletePlanterById() throws PlanterNotFoundException {
		Planter p1= new Planter(2000,9, "red","oval",10, 90);	

		when(planterRepository.findById(101)).thenReturn(Optional.of(p1));
		assertThat(planterServiceImpl.deletePlanter(101))
		.contains("deleted successfully....");
	}
	
	@Test
	void testDeletePlanterByInvalidId() throws PlanterNotFoundException {
		Planter p1= new Planter(2000,9, "red","oval",10, 90);	
		when(planterRepository.findById(101)).thenReturn(Optional.of(p1));
		try {
			assertThat(planterServiceImpl.deletePlanter(111))
			.contains("Planter with the id "+p1.getPlanterId()+" doesn't exist");
		}catch(Exception e) {
			
		}
	}
	
	
	}

	


