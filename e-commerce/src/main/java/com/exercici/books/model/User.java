package com.exercici.books.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_tbl")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	private String nickName, userName, password;
	@ElementCollection(targetClass = LineItem.class)
	private List<LineItem> cart = new ArrayList<>();
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, orphanRemoval = true, targetEntity = Order.class/*, cascade = CascadeType.ALL*/)
	private List<Order> ordersList = new ArrayList<>();

	public User() {
	}

	public User(String nickName, String userName, String password) {
		this.nickName = nickName;
		this.userName = userName;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<LineItem> getCart() {
		return cart;
	}

	public void setCart(List<LineItem> cart) {
		this.cart = cart;
	}

	public List<Order> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<Order> ordersList) {
		this.ordersList = ordersList;
	}

//	public void updateLineItem(LineItem lineItem) {
//		int bookId = lineItem.getBook().getId();
//		LineItem lineItemToUpdate = this.order.stream().filter(l -> l.getBook().getId() == bookId).collect(Collectors.toList()).get(0);
//		int index = this.order.indexOf(lineItemToUpdate);
//		
//		if (lineItemToUpdate.getQuantity() != lineItem.getQuantity())
//			this.order.get(index).setQuantity(lineItem.getQuantity());
//		
//		if (lineItemToUpdate.getStatus() != lineItem.getStatus())
//			this.order.get(index).setStatus(lineItem.getStatus());
//	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nickName=" + nickName + ", userName=" + userName + ", password=" + password
				+ ", cart=" + cart + ", ordersList=" + ordersList + "]";
	}

}

//package com.exercici.books.model;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.ElementCollection;
//import javax.persistence.Embedded;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "user_tbl")
//public class User {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "user_id")
//	private int id;
//
//	private String nickName;
//	private String userName;
//	private String password;
//
//	@OneToOne(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
//	private Basket basket;
//
//	@ElementCollection(targetClass = Book.class)
//	private List<Book> confirmedBooksList = new ArrayList<>();
//
//	public User() {
//	}
//
//	public User(String userName, String nickName, String password) {
//		this.nickName = nickName;
//		this.userName = userName;
//		this.password = password;
//		this.basket = new Basket(this);
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
//	public String getNickName() {
//		return nickName;
//	}
//
//	public void setNickName(String nickName) {
//		this.nickName = nickName;
//	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
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
//	public List<Book> getConfirmedBooksList() {
//		return confirmedBooksList;
//	}
//
//	public void setConfirmedBooksList(List<Book> confirmedBooksList) {
//		this.confirmedBooksList = confirmedBooksList;
//	}
//
//	public boolean checkPasswordIsCorrect(String password2) {
//		Boolean result = null;
//		if (this.password == password2)
//			result = true;
//		return result;
//	}
//
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", nickName=" + nickName + ", userName=" + userName + ", password=" + password
//				+ ", basket=" + basket + ", confirmedBooksList=" + confirmedBooksList + "]";
//	}
//
//}
