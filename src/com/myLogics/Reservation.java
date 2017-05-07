package com.myLogics;

public class Reservation extends Thread {

	private int seatsNeeded;
	
	public Reservation(int seats, Runnable target, String name){
		super(target,name);
		this.seatsNeeded = seats;
	}
	
	public int getSeatsNeeded(){
		return seatsNeeded;
	}
}
