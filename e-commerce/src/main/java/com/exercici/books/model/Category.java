package com.exercici.books.model;

public enum Category {

	BESTSELLER("BESTSELLER"), COMIC("COMIC"), CHILDRENSSTORY("CHILDRENSSTORY"), OV("OV");

	private final String value;

	Category(String value) {
		this.value = value;
	}

	public String value() {
		return this.value;
	}
}
