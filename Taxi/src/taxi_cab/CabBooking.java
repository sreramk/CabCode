/**
 * Copyright (c) 2018 K Sreram, All rights reserved.
 */


package taxi_cab;

import java.util.Scanner;

public class CabBooking {
	
	/// these are not determined in the Cab class. 
	
	private static Integer currentBookingId = 1;
	private Integer   bookingID;
	private Integer   customerID;
	private Character from;
	private Character to;
	private Integer   pickupTime;
	private Integer   dropTime;
	private Integer   travelCost;

	
	public CabBooking () {
		this.bookingID   =  currentBookingId;
		currentBookingId++; 
	}
	
	public Integer getBookingID() {
		return bookingID;
	}

	
	public Integer getCustomerID() {
		return customerID;
	}
	
	public Character getFrom() {
		return from;
	}

	public Character getTo() {
		return to;
	}
	
	public Integer getPickupTime() {
		return pickupTime;
	}
	
	public Integer getDropTime() {
		return dropTime;
	}
	
	public Integer getTravelCost() {
		return travelCost;
	}
	
	public Integer distance () {
		return new Integer(Math.abs(from - to)*15);
	}
	
	public Integer setReturnTravelCost() {
		travelCost  = 100 + ( distance() - 5)*10;
		return travelCost;
	}
	
	public Integer setDropTime () {
		dropTime = getPickupTime() + (distance() / 15);
		return dropTime;
	}
	
	
	public void getCustomerInput (Scanner scan) {
		
		
		System.out.println("Enter customer ID: ");
		this.customerID = scan.nextInt();
		System.out.println("Pickup point     : ");
		this.from       = scan.next().charAt(0);
		System.out.println("Drop point       : ");
		this.to         = scan.next().charAt(0);
		System.out.println("Pickup time      : ");
		this.pickupTime = scan.nextInt();
	}
	
	
	public void displayDetails () {
		setReturnTravelCost();
		setDropTime();
		System.out.println(	getBookingID().toString()  + " \t " +
		   					getCustomerID().toString() + " \t " +
		   					getFrom().toString()       + " \t " +
		   					getTo().toString()         + " \t " +
		   					getPickupTime().toString() + " \t " +
		   					getDropTime().toString()   + " \t " +
		   					getTravelCost().toString() 
		   );
	}
	
	
	
}
