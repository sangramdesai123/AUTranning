package day2;

import java.util.Scanner;

/*
 * Lift System
 * 
 * user press button on floor
 * check if floor is valid and return message
 * 
 * then user press floor button to go
 * check the floor and update floor
 * 
 * */
public class Lift {
	int currentFloor;
	final int topFloor;
	final int lastFloor;
	
	Lift(int topFloor,int lastFloor){
		this.currentFloor=0;
		this.topFloor=topFloor;
		this.lastFloor= lastFloor;		
	}
	
	boolean validposition(int position) {
		if(position <= this.topFloor && position >= this.lastFloor ) {
			return true;
		}else {
			return false;
		}
	}
	void startlift(int floor) {
		if(validposition(floor)) {
			if(this.currentFloor!=floor) {
				System.out.println("Lift stared from "+this.currentFloor+" to "+ floor);
				this.currentFloor =floor;
				System.out.println("Lift reach on Floor "+this.currentFloor);
			}
			else {
				System.out.println("Lift reach on Floor "+this.currentFloor);
			}
		}else {
			System.out.println("Select the valid Floor");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new  Scanner(System.in);
		
		Lift lift = new Lift(15,1);
		int position;
		int floor;
		while(true) {
			System.out.println("Which Floor You are on ? ");
			position=sc.nextInt();
			if(lift.validposition(position)) {
				System.out.println("Select the Floor ");
				floor=sc.nextInt();
				lift.startlift(floor);
			}else {
				System.out.println("Select the valid Floor");
			}
		}
		
		
	}

}
