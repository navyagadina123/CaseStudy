package com.cg.opna.planter.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlanterTest {
	

		Planter p1;
		@BeforeEach
		public void before() {
			Planter p1 = new Planter(2000,9, "red","oval",10, 90);
		}
		
		
		@AfterEach
		public void after() {
			p1=null;
		}
		
//		@Test
//		void testGetPlanterId() {
//			assertEquals(2000, p1.getPlanterId());
//		}
//
//		@Test
//		void testGetPlanterHeight() {
//			assertEquals(9, p1.getPlanterHeight());
//		}
//
//		@Test
//		void testGetPlanterColor() {
//			assertEquals("red", p1.getPlanterColor());
//		}
//		
//		@Test
//         void testGetPlanterShape() {
//			assertEquals("oval",p1.getPlanterShape());
//		}
//		
//		@Test
//		void testGetPlanterCost() {
//			assertEquals(90, p1.getPlanterCost());
//		}
//
//		@Test
//		void testGetPlanterStock() {
//			assertEquals(10, p1.getPlanterStock());
//		}
//		
//		
//		@Test
//		void testSetPlanterId() {
//			p1.setPlanterId(2001);
//			assertEquals(2000, p1.getPlanterId());
//		}
//
//		@Test
//		void testSetPlanterHeight() {
//			p1.setPlanterHeight(6);
//			assertEquals(6, p1.getPlanterHeight());
//		}
//
//		@Test
//		void testSetPlanterShape() {
//			p1.setPlanterShape("round");
//			assertEquals("round",p1.getPlanterShape());
//		}
//
//		@Test
//		void testSetPlanterColor() {
//			p1.setPlanterShape("red");
//			assertEquals("red",p1.getPlanterColor());
//		}
//		@Test
//		void testSetPlanterCost() {
//			p1.setPlanterCost(100);
//			assertEquals(100, p1.getPlanterCost());
//		}
//		
//		@Test
//		void testSetPlanterStock() {
//			p1.setPlanterStock(18);
//			assertEquals(18, p1.getPlanterStock());
//		}

	}


