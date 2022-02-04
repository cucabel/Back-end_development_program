package com.rockets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rocket {
	private String code;
	private int thrustersNumber;
	private int [] thrustersMaxPowerArray;
	private List<Thruster> thrustersList = new ArrayList<>();
	private int n = 0;
	
	public Rocket() {};
	
	public Rocket(String code, int thrustersNumber, int [] thrustersMaxPowerArray) throws Exception {
		validateCode(code);
		this.thrustersNumber = thrustersNumber;
		this.thrustersMaxPowerArray = thrustersMaxPowerArray;
		
		addThrusters(thrustersMaxPowerArray);		
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getThrustersNumber() {
		return thrustersNumber;
	}

	public void setThrustersNumber(int thrustersNumber) {
		this.thrustersNumber = thrustersNumber;
	}

	public int[] getThrustersMaxPowerArray() {
		return thrustersMaxPowerArray;
	}

	public void setThrustersMaxPowerArray(int[] thrustersMaxPowerArray) {
		this.thrustersMaxPowerArray = thrustersMaxPowerArray;
	}

	public List<Thruster> getThrustersList() {
		return thrustersList;
	}

	public void setThrustersList(List<Thruster> thrustersList) {
		this.thrustersList = thrustersList;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
		
	public void validateCode(String code) throws Exception {
		Pattern pattern = Pattern.compile("\\w\\w\\w\\w\\w\\w\\w\\w");		
		Matcher matcher = pattern.matcher(code);
		if (!matcher.find())
			throw new Exception();
		else
			this.code = code;
	}
	
	private void addThrusters(int [] thrustersMaxPowerArray) {
		int thrusterMaxPower = 0;
		int currentPower = 0;
		
		for (int i = 0; i < thrustersMaxPowerArray.length; i++) {
			thrusterMaxPower = thrustersMaxPowerArray[i];
			thrustersList.add(new Thruster(thrusterMaxPower, currentPower));
		}
		System.out.println(thrustersList);
	}	

	public int rocketMaxPower() {
		int maxPower = 0;
		
		Iterator<Thruster> iterator = thrustersList.iterator();
		
		while (iterator.hasNext())
		{
			Thruster value = iterator.next();
			
			if(value.getMaxPower() > maxPower)
				maxPower = value.getMaxPower();			
		}		
		return maxPower;	
	}
	
	public void accelerate(int n) {
		ExecutorService executor = Executors.newFixedThreadPool(this.getThrustersNumber());			
			for (int i = 0; i < this.thrustersNumber; i++) {
				Thruster oneThruster = thrustersList.get(i);
				
			    Runnable r1 = new Runnable() {
			        @Override
			        public void run()									
			        {
			        	oneThruster.accelerate(n);											
			        	
			    			if (oneThruster.getCurrentPower() > rocketMaxPower()) 
			    				oneThruster.setCurrentPower(rocketMaxPower());
			        }
			    };		
			    executor.execute(r1);  					
			  }  
			executor.shutdown();
			while (!executor.isTerminated()) {}
	}
	
	public void brake(int n) {
		ExecutorService executor = Executors.newFixedThreadPool(this.getThrustersNumber());			
			for (int i = 0; i < this.thrustersNumber; i++) {
				Thruster oneThruster = thrustersList.get(i);
				
			    Runnable r1 = new Runnable() {
			        @Override
			        public void run() {
			        	oneThruster.brake(n);											
			        	
			    			if (oneThruster.getCurrentPower() <= 0) 
			    				oneThruster.setCurrentPower(0);
			        }
			    };		
			    executor.execute(r1);  					
			  }  
			executor.shutdown();
			while (!executor.isTerminated()) {}
	}

	public double currentSpeed() {
		double speed = 0;
		double inicialspeed = 0;
		
		double powerSum = 0;		
		for (Thruster thruster : thrustersList) {
			if (thruster.getCurrentPower() > thruster.getMaxPower())
				thruster.setCurrentPower(thruster.getMaxPower());
			
			powerSum += thruster.getCurrentPower();
		}
		
		speed = inicialspeed + (100 * Math.sqrt(powerSum));
		return speed;
	}

	public String toString() {
		String result = "Rocket's code: " + code + "\nThrusters' number: " + thrustersNumber + "\nThrusters' Max. Power: " + "\nRocket' Max. power: ";
		
		for (int thrusterMaxPower : thrustersMaxPowerArray) {
			result += String.valueOf(thrusterMaxPower) + ", ";
		}
		
		result += "\nRocket' Max. power: " + rocketMaxPower();
			return result;
	}

}
