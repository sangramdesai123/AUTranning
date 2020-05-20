package com.accolite;

public class Leapyear {
	
	public int add(int a, int b) {
		return a+b;
	}
	
	public boolean  checkLeap(int year) {
		if((year % 4 == 0 && year % 100 !=0 ) || year % 400 == 0)
			return true;
		else
			return false;
	}
}
