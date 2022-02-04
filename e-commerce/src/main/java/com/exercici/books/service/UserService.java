package com.exercici.books.service;

import java.util.List;

import com.exercici.books.model.ApiResponse;
import com.exercici.books.model.LineItem;
import com.exercici.books.model.User;

public interface UserService {

	public ApiResponse<User> saveUser(User user);

	public List<User> listUsers();

	public ApiResponse<User> getOne(int userId);

	public User updateUserPassword(int userId, User user);

	public Void delete(int userId);
	
	public User addBook(int userId, LineItem lineItem);
	
	public User deleteLineItem(int userId, LineItem lineItem);

	public User updateCart(int userId, List<LineItem> cart);

}
