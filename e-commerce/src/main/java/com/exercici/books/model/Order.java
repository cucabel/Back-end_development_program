package com.exercici.books.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "order_tbl")
@JsonIgnoreProperties(value = "user")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ElementCollection(targetClass = LineItem.class)
	private List<LineItem> lineItemsList = new ArrayList<>();

	@ManyToOne/*(cascade = CascadeType.ALL)*/
	@JoinColumn(name = "user_id")
	private User user;

	@Column
	private int total;

	public Order() {
	}

	public Order(List<LineItem> lineItemsList, User user) {
		this.user = user;
		this.lineItemsList = lineItemsList;
		this.total = calculateTotalPrice(lineItemsList);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<LineItem> getLineItemsList() {
		return lineItemsList;
	}

	public void setLineItemsList(List<LineItem> lineItemsList) {
		this.lineItemsList = lineItemsList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int calculateTotalPrice(List<LineItem> lineItemsList) {
		return lineItemsList.stream().map(l -> l.getBook().getPrice() * l.getQuantity()).reduce(0, Integer::sum);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", lineItemsList=" + lineItemsList + ", user=" + user + ", total=" + total + "]";
	}

}

//package com.exercici.books.model;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//@Embeddable
//@Entity
//@Table(name = "basket_tbl")
//@JsonIgnoreProperties(value = "user")
//public class Basket {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "user_id")
//	private User user;
//
//	@OneToMany(mappedBy = "basket", fetch = FetchType.EAGER, orphanRemoval = true, targetEntity = LineItem.class, cascade = CascadeType.ALL)
//	private List<LineItem> lineItemsList = new ArrayList<>();
//
//	@Column
//	private int total;
//
//	public Basket() {
//	}
//
//	public Basket(User user) {
//		this.user = user;
//		total(lineItemsList);
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public List<LineItem> getLineItemsList() {
//		return lineItemsList;
//	}
//
//	public void setLineItemsList(List<LineItem> lineItemsList) {
//		this.lineItemsList = lineItemsList;
//	}
//
//	public int getTotal() {
//		return total;
//	}
//
//	public void setTotal(int total) {
//		this.total = total;
//	}
//
//	public int total(List<LineItem> lineItemsList) {
//		for (LineItem item : lineItemsList)
//			this.total += item.getTotal();
//		return total;
//	}
//
//	@Override
//	public String toString() {
//		return "Basket [id=" + id + ", user=" + user + ", lineItemsList=" + lineItemsList + ", total=" + total + "]";
//	}
//
//}

