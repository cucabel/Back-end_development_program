package com.payments.application;

import com.payments.domain.IPaymentRate;

public class PaymentFactory {

	public static IPaymentRate createPaymentRateManager() {
		return new IPaymentRate() 	 {	
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth * 1.1;
			}
		};
	}

	public static IPaymentRate createPaymentRateBoss() {
		return new IPaymentRate() {	
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth * 1.5;					
			}													
		};
	}
	
	public static IPaymentRate createPaymentRateEmployee() {
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth * 0.85;		 								
			}
		};
	}
	
}
