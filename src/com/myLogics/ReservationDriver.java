package com.myLogics;

public class ReservationDriver {

	public static void main(String[] args) {
		ReservationImpl target = new ReservationImpl();

		Reservation t1 = new Reservation(2, target, "Srinadh");
		Reservation t2 = new Reservation(2, target, "Chethana");
		t1.start();
		t2.start();
	}

}
