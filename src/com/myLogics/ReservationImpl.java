package com.myLogics;

public class ReservationImpl implements Runnable {

	private static int TicketsAvailable = 2;


	@Override
	public void run() {
		Reservation reserve = (Reservation) Thread.currentThread();
		boolean ticketsBooked = this.bookTickets(reserve.getSeatsNeeded(),reserve.getName());
		if(ticketsBooked == true){
			System.out.println("Congrats!! "+Thread.currentThread().getName()+".. Number of Seats"
					+ " requested("+reserve.getSeatsNeeded()+") are booked.");
		}else{
			System.out.println("Sorry!! "+Thread.currentThread().getName()+".. Number of Seats"
					+ " requested("+reserve.getSeatsNeeded()+") are not available.");
		}
	}


	public synchronized boolean  bookTickets(int seatsNeeded, String name) {
		System.out.println("Welcome "+Thread.currentThread().getName()+" Number of Tickets"
				+ "Available are: "+TicketsAvailable);
		if(seatsNeeded > TicketsAvailable){
			return false;	
		}else{
			TicketsAvailable -= seatsNeeded;
			return true;
		}
		
	}

}




/*---------- My Code -----------------*/
/*System.out.println("Seats Reserved by "+ Thread.currentThread().getName()+" are "+ reserve.getNoOfTickets());
synchronized(this){
	if(reserve.getNoOfTickets() <= TicketsAvailable){
		System.out.println("Successfull Registeration");
		TicketsAvailable = TicketsAvailable - reserve.getNoOfTickets();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}else{
		System.out.println("Sorry, Seats are not available: "+ TicketsAvailable);
	}
}*/