package com.edvin.projects.bookstore.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UtilClassTest {
	
	
	UtilClass utilClass = new UtilClass();
	
	@Test
	void testAddThreeNumbers() {
		int result = utilClass.add(1, 2, 3);
		assertEquals(6, result);
	}

}
