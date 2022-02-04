package com.exercici.books.model;

public enum Status {
	
	SHOPPINGCART("SHOPPINGCART"), CHECKOUT("CHECKOUT");

	private final String value;

	Status(String value) {
		this.value = value;
	}

	public String value() {
		return this.value;
	}

}
