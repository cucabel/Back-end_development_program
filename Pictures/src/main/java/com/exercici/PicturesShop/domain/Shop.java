package com.exercici.PicturesShop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

@Entity(name = "Shop")
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shop_id")
	private long id;

	private String name;
	private int capacity;

	@OneToMany(mappedBy = "shop", fetch = FetchType.EAGER, orphanRemoval = true, targetEntity = Picture.class)
	private List<Picture> pictures = new ArrayList<Picture>();

	public Shop() {
	}

	public Shop(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
		getPictures();
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	@Override
	public String toString() {
		return "Shop [id=" + id + ", name=" + name + ", capacity=" + capacity + ", pictures=" + pictures + "]";
	}

}
