package com.exercici.books.model;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Embeddable
public class LineItem {

	@OneToOne // @OneToOne, no operations are cascaded by default | cascade = CascadeType.MERGE: persist -> the object does not exist yet -> making it a unique managed instance doesn't hurt | merge -> a managed instance of the object may already exist. You don't want to replace that unique managed instance, because some other object might reference it, believing it is the managed object.
	@JoinColumn(name = "book_id") // updatable=false -> read only association, it is not required, with not cascade the operations is enough
	private Book book;
	private int quantity;
	private String status;

//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "user_id")
//	private User user;	
//
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "order_id")
//	private Order order;	

	public LineItem() {
	}

	public LineItem(Book book, int quantity) {
		this.book = book;
		this.quantity = quantity;
		this.status = Status.SHOPPINGCART.value();
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//	
//	public Order getOrder() {
//	return order;
//}
//
//public void setOrder(Order order) {
//	this.order = order;
//}

	@Override
	public String toString() {
		return "LineItem [book=" + book + ", quantity=" + quantity + ", status=" + status + "]";
	}
	
}

//package com.exercici.books.model;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//@Entity
//@Table(name = "lineitem_tbl")
//@JsonIgnoreProperties(value = "basket")
//public class LineItem {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@JoinColumn(name = "lineitem_id")
//	private int id;
//
//	private int quantity;
//	private int price;
//	private int total;
//
//	@OneToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "book_id")
//	private Book book;
//
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "basket_id")
//	private Basket basket;
//
//	public LineItem() {
//	}
//
//	public LineItem(int quantity, Book book, Basket basket) {
//		this.quantity = quantity;
//		this.book = book;
//		this.basket = basket;
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
//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//
//	public int getPrice() {
//		return price;
//	}
//
//	public void setPrice(int price) {
//		this.price = price;
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
//	public Book getBook() {
//		return book;
//	}
//
//	public void setBook(Book book) {
//		this.book = book;
//	}
//
//	public Basket getBasket() {
//		return basket;
//	}
//
//	public void setBasket(Basket basket) {
//		this.basket = basket;
//	}
//
//	public void total() {
//		this.price = this.book.getPrice();
//		this.total = this.quantity * this.price;
//	}
//
//	@Override
//	public String toString() {
//		return "LineItem [id=" + id + ", quantity=" + quantity + ", price=" + price + ", total=" + total + ", book="
//				+ book + ", basket=" + basket + "]";
//	}
//
//}
