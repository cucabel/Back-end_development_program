package com.vehicles.project;

import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {		
	
	public static void main (String[] args) throws Exception {
		//Phase 1.1.		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Would you like to create a car or a bike?");
		String vehicle = in.next();
		
		String plate;
		Pattern pattern = Pattern.compile("\\d\\d\\d\\d[a-zA-Z][a-zA-Z][a-zA-Z]?");		
		Matcher matcher;
		    
		do {
			System.out.println("Enter yours vehicle's plate: ");
			plate = in.next();
			matcher = pattern.matcher(plate);
		} while (!matcher.find());

		System.out.println("Enter yours vehicle's brand: ");
		String brand = in.next();
			
		System.out.println("Enter yours vehicle's color: ");
		String color = in.next();
			
		//Phase 1.2.		
		Car car = null;
		Bike bike = null;
		if (vehicle.equalsIgnoreCase("car")) {
			car = new Car(plate, brand, color); 
			System.out.println("You have created a car");
		} else {
			bike = new Bike(plate, brand, color);
			System.out.println("You have created a bike");
		}
			
		//Phase 1.3.		
		System.out.println("Enter yours wheels' brand: ");
		String wheelBrand = in.next();
			
		Double wheelDiameter;
			
		do {
			System.out.println("Enter yours wheels' diameter: ");
			String StringwheelDiameter = in.next();
			wheelDiameter = Double.parseDouble(StringwheelDiameter);
		} while (wheelDiameter <= 0.4 || wheelDiameter >= 4);
		
		Wheel backRightWheel = new Wheel();			
		backRightWheel.setBrand(wheelBrand);
		backRightWheel.setDiameter(wheelDiameter);
		
		Wheel backLeftWheel = new Wheel();			
		backLeftWheel.setBrand(wheelBrand);
		backLeftWheel.setDiameter(wheelDiameter);

		Wheel frontRightWheel = new Wheel();
		frontRightWheel.setBrand(wheelBrand);
		frontRightWheel.setDiameter(wheelDiameter);

		Wheel frontLeftWheel = new Wheel();			
		frontLeftWheel.setBrand(wheelBrand);
		frontLeftWheel.setDiameter(wheelDiameter);
			
		if(vehicle.equalsIgnoreCase("car")) {
			List<Wheel> backWheels = new ArrayList<>();				
			backWheels.add(backRightWheel);
			backWheels.add(backLeftWheel);
			
			List<Wheel> frontWheels = new ArrayList<>();				
			frontWheels.add(frontRightWheel);
			frontWheels.add(frontLeftWheel);
				
			car.addWheels(frontWheels, backWheels);
			System.out.println("You have added the wheels to your car");
		} else {
			List<Wheel> backWheel = new ArrayList<>();				
			backWheel.add(backRightWheel);
			
			bike.addOneWheel(backWheel);
			System.out.println("You have added the backwheels to your bike");
				
			List<Wheel> frontWheel = new ArrayList<>();				
			frontWheel.add(frontRightWheel);
				
			bike.addOneWheel(frontWheel);
			System.out.println("You have added the frontwheels to your bike");
		}
		
		in.close();		
	}
}
