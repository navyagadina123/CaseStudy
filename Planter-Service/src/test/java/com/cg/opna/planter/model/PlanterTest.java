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
		
		@Test
		void testGetPlanterId() {
			assertEquals(2001, p1.getPlanterId());
		}

		@Test
		void testGetPlanterHeight() {
			assertEquals(9, p1.getPlanterHeight());
		}

		@Test
		void testGetPlanterColor() {
			assertEquals("red", p1.getPlanterColor());
		}
		
		@Test
         void testGetPlanterShape() {
			assertEquals("oval",p1.getPlanterShape());
		}
		
		@Test
		void testGetPlanterCost() {
			assertEquals(100, p1.getPlanterCost());
		}

		@Test
		void testGetPlanterStock() {
			assertEquals(100, p1.getPlanterStock());
		}
		
		
		@Test
		void testSetPlanterId() {
			p1.setPlanterId(111);
			assertEquals(101, p1.getPlanterId());
		}

		@Test
		void testSetPlanterHeight() {
			p1.setPlanterHeight(8);
			assertEquals(8, p1.getPlanterHeight());
		}

		@Test
		void testSetPlanterShape() {
			p1.setPlanterShape("oval");
			assertEquals("oval",p1.getPlanterShape());
		}

		@Test
		void testSetPlanterColor() {
			p1.setPlanterShape("red");
			assertEquals("red",p1.getPlanterColor());
		}
		@Test
		void testSetPlanterCost() {
			p1.setPlanterCost(100);
			assertEquals(100, p1.getPlanterCost());
		}
		
		@Test
		void testSetPlanterStock() {
			p1.setPlanterStock(100);
			assertEquals(100, p1.getPlanterStock());
		}

	}


