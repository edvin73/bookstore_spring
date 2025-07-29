package com.edvin.projects.bookstore.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculateServiceTest {
	
	private final CalculateService service;
	
	public CalculateServiceTest() {
		this.service = new CalculateService();
	}
	
	@Test
	void testGetSumWithMultipleNumbers() {
		int result = service.getSum(1, 2, 3, 4, 5);
		assertEquals(15, result);
	}
	

	 
}
