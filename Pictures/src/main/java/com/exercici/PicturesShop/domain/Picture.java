package com.exercici.PicturesShop.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "Picture")
@JsonIgnoreProperties(value = "shop")
public class Picture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "picture_id")
	private long id;

	private String name;
	private double price;

	@Nullable
	private String authorName;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate date;

	@ManyToOne
	@JoinColumn(name = "shop_id")
	private Shop shop;

	public Picture() {
	}

	public Picture(String name, double price, String authorName, Shop shop) {
		this.name = name;
		this.price = price;
		this.authorName = authorName;
		this.date = LocalDate.now();
		this.shop = shop;
	}

	public long getId() {
		return id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getDate() {
		return date;
	}

	public Shop getShop() {
		return shop;
	}

	@Override
	public String toString() {
		return "Picture [id=" + id + ", name=" + name + ", price=" + price + ", authorName=" + authorName + ", date="
				+ date + ", shop=" + shop + "]";
	}

}
