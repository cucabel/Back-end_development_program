package com.rockets;

public class Main {
	
	public static void main (String[] args) throws Exception {																	
		//2. 															
		int [] thrustersMaxPowerArrayRocket1 = {10, 30, 80};
		Rocket rocket1 = new Rocket("32WESSDS", 3, thrustersMaxPowerArrayRocket1);

		int [] thrustersMaxPowerArrayRocket2 = {30, 40, 50, 50, 30, 10};
		Rocket rocket2 = new Rocket("LDSFJA32", 6, thrustersMaxPowerArrayRocket2 );
		
		System.out.println(rocket1);
		System.out.println(rocket2);
		
		//3. Rockets' current speed
		System.out.println(rocket1.currentSpeed());
		System.out.println(rocket2.currentSpeed());
		
		//4. Accelerates the rockets 3 times
		rocket1.accelerate(2);
		rocket2.accelerate(2);
		
		//5. Rockets' current speed
		System.out.println(rocket1.currentSpeed());
		System.out.println(rocket2.currentSpeed());
		
		//6. Brakes rocket1 5 times and accelerates rocket2 7 times
		rocket1.brake(5);												
		rocket2.accelerate(7);											
		
		//7. Rockets' current speed
		System.out.println(rocket1.currentSpeed());
		System.out.println(rocket2.currentSpeed());
		
		//8. Accelerates the rockets 3 times
		rocket1.accelerate(15);
		rocket2.accelerate(15);
		
		//9. Rockets' current speed
		System.out.println(rocket1.currentSpeed());
		System.out.println(rocket2.currentSpeed());
	}

}
