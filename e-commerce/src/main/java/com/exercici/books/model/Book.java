package com.exercici.books.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "book_tbl")
@JsonIgnoreProperties(value = "lineItemList")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "book_id")
	private int id;

	private String title;
	private String author;
	private String resume;
	private String category;
	private int price;
	private LocalDate dataRegistration;
	private int copies;
	private Boolean outOfStock;
	private Boolean recommended;

//	@ElementCollection(targetClass = LineItem.class)
//	private List<LineItem> lineItemList;

	public Book() {
	}

	public Book(String title, String author, String resume, Category category, int price, int copies,
			Boolean recommended) {
		this.title = title;
		this.author = author;
		this.resume = resume;
		this.category = category.value();
		this.price = price;
		this.dataRegistration = LocalDate.now();
		this.copies = copies;
		this.outOfStock = false;
		this.recommended = recommended;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDate getDataRegistration() {
		return dataRegistration;
	}

	public void setDataRegistration(LocalDate dataRegistration) {
		this.dataRegistration = dataRegistration;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	public Boolean getOutOfStock() {
		return outOfStock;
	}

	public void setOutOfStock(Boolean outOfStock) {
		this.outOfStock = outOfStock;
	}

	public Boolean getRecommended() {
		return recommended;
	}

	public void setRecommended(Boolean recommended) {
		this.recommended = recommended;
	}

//	public LineItem getLineItem() {
//		return lineItem;
//	}
//
//	public void setLineItem(LineItem lineItem) {
//		this.lineItem = lineItem;
//	}

	public void addCopy(int quantity) {
		this.setCopies(getCopies() + quantity);
	}

	public void restCopy(int quantity) {
		this.setCopies(getCopies() - quantity);
		
		if (this.getCopies() == 0)
			this.outOfStock = true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", resume=" + resume + ", category="
				+ category + ", price=" + price + ", dataRegistration=" + dataRegistration + ", copies=" + copies
				+ ", recommended=" + recommended + "]";
	}

}
