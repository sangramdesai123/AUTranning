package com.accolite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LeapyearTest {
	
	@Test
	void addTest() {
		Leapyear lp=new Leapyear();
		
		//add two number testing
		
		int sum=lp.add(5, 2);
		assertEquals(sum,6);
	}
	
	@Test
	public void leaptest() {
		Leapyear lp = new Leapyear();
		
		//check if year is leap or not
		
		assertTrue(lp.checkLeap(2016));
	}
}
