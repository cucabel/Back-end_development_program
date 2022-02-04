package com.rockets;

import com.rockets.DriveInterface;

public class Thruster implements DriveInterface {
	private int maxPower;
	private int currentPower;
	
	public Thruster() {}
	
	public Thruster(int maxPower, int currentPower) {
		this.maxPower = maxPower;
		this.currentPower = currentPower;
	}
	
	public int getMaxPower() {
		return maxPower;
	}

	public void setMaxPower(int maxPower) {
		this.maxPower = maxPower;
	}

	public int getCurrentPower() {
		return currentPower;
	}

	public void setCurrentPower(int currentPower) {
		this.currentPower = currentPower;
	}
	
	@Override
	public int accelerate(int n) {
		currentPower += 10 * n;	
		return currentPower;
	}

	@Override
	public int brake(int n) {
		currentPower -= 10 * n;
		return currentPower;
	}

	public String toString() {
		String result = "Thruster's Max. Power :";
		result += String.valueOf(maxPower);
		return result;
	}

}
