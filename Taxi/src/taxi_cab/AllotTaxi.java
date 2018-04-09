/**
 * Copyright (c) 2018 K Sreram, All rights reserved.
 */

package taxi_cab;

import java.util.ArrayList;
import java.util.Scanner;

public class AllotTaxi {
	
	private ArrayList <Cab> allCabs;
	
	
	
	private Integer cabDistance (Cab cab, Character position) {
		return Math.abs(cab.getLastStationedPosition() - position);
	}
	
	public class Responce {
		
		private boolean canCabBeAlloted;
		private Integer allotedCab;
		
		public Responce (boolean pCanCabBeAlloted, Integer pAllotedCab) {
			canCabBeAlloted = pCanCabBeAlloted;
			allotedCab      = pAllotedCab;
		}
		
		public void display () {
			if (canCabBeAlloted) {
				System.out.println("Cab can be alloted");
				System.out.println("Taxi-" + allotedCab.toString() + " Allotted");
			} else {
				System.out.println("Cab cannot be alloted");
			}
			
		}
		
	}

	
	
	public AllotTaxi (Integer noOfCabs) {
		allCabs = new ArrayList <Cab> ();
		for (int i = 0; i < noOfCabs; i++) {
			allCabs.add(new Cab());
		}
	}
	
	
	
	public Responce getAndProcessResult(Scanner scan) {
		
		CabBooking booking = new CabBooking();
		booking.getCustomerInput(scan);
		
		Cab nearest = null;
		ArrayList<Cab> nearestCabList = new ArrayList<Cab>();
		Integer nearestDistance = null;
		
		for (Cab car: allCabs) {
			
			
			if (!car.isCabTravelling(booking.getPickupTime()) ) {
			
				if (nearest != null) { 
					
					if (nearestDistance > cabDistance (car, booking.getFrom())) {
					
						nearestDistance = cabDistance (car, booking.getFrom());
						nearest         = car;
						nearestCabList.clear();
						nearestCabList.add(car);
						
					} else if (nearestDistance == cabDistance (car, booking.getFrom())) {
						nearestCabList.add(car);
					}
				} else {
					
					nearest = car;
					nearestDistance = cabDistance (nearest, booking.getFrom());
			
				}
			
			}
			
		}
		
		
		if (nearest == null) {
			return new Responce (false, null);
		}
		
		
		Cab bestMatch = nearest;
		
		for (Cab car : nearestCabList) {
			if (car.getEarnings() < bestMatch.getEarnings()) {
				bestMatch = car;
			}
		}
		
		bestMatch.newBooking(booking);
		
		return new Responce (true, bestMatch.getId());

	}
	
	public void displayAllCabs() {
		for (Cab car : allCabs) {
			car.display();
		}
	}
	
	
	
}
