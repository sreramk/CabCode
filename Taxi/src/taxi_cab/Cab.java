/**
 * Copyright (c) 2018 K Sreram, All rights reserved.
 */


package taxi_cab;

import java.util.ArrayList;

public class Cab {
	
	private static Integer currentID = 1;
	
	private Integer id; 
	private Integer earnings;
	
	/// This is equal to bookings.get(noOfBookings-1).getTo() if the taxi has 
	/// finished the last journey.
	/// For the initial time it is equal to "A"
	private Character  lastStationedPosition;
	private ArrayList<CabBooking> bookings;
	
	
	public Cab () {
		this.id = currentID;
		currentID++;
		
		this.earnings = 0;
		this.lastStationedPosition = 'A';
		
		this.bookings = new ArrayList<CabBooking>();
		
	}
	
	public Integer getId() {
		return id;
	}

	public Integer getEarnings() {
		return earnings;
	}

	public Character getLastStationedPosition() {
		return lastStationedPosition;
	}

	
	public boolean isCabTravelling(Integer currentTime) {
		
		Integer noOfBookings = bookings.size();
		return ((noOfBookings != 0) && 
				(bookings.get(noOfBookings-1).getDropTime() > currentTime ));
	
	}
	
	public void newBooking (CabBooking booking) {
		
		earnings              += booking.setReturnTravelCost();
		bookings.add(booking);
		Integer noOfBookings   = bookings.size();
		lastStationedPosition  = bookings.get(noOfBookings-1).getTo();
	
	}
	
	public void display () {
		System.out.println("Taxi number Taxi-" + getId());
		System.out.println("Total earnings: "  + getEarnings());
		
		
		System.out.println("BookingID \t CustomerID \t From \t To \t PickupTime \t DropTime \t Amount");
		
		for (CabBooking inst : bookings) {
			inst.displayDetails();
		}
		
	}
	
}
