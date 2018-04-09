/**
 * Copyright (c) 2018 K Sreram, All rights reserved.
 */


package taxi_cab;

import java.util.Scanner;

public class MainMethod {
	
	public static void main (String [] args) {
		
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Total number of cabs:");
		
		AllotTaxi allotTaxi = new AllotTaxi(scan.nextInt());
		
		while (true) {
			System.out.println(" Menu" );
			System.out.println(" 1. Display all bookings" );
			System.out.println(" 2. Get input" );
			System.out.println(" 3. exit");
			
			Integer choice = scan.nextInt();
			
			if (choice == 1) {
				allotTaxi.displayAllCabs();
			} else if (choice == 2) {
				AllotTaxi.Responce result = allotTaxi.getAndProcessResult(scan);
				result.display();
			} else if (choice == 3) {
				break;
			} else {
				System.out.println("Invalid option");
			}
			
		}
		
		
	}

}
