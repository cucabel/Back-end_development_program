package com.exercici.books.service;

import java.util.List;

import com.exercici.books.model.ApiResponse;
import com.exercici.books.model.Order;

public interface OrderService {

	public ApiResponse<Order> saveOrder(int userId, Order order);
	
	public ApiResponse<Order> getOrder(int userId, int orderId);
	
	public Void deleteOrder(int userId, int orderId);

	List<Order> getAllOrders(int userId);

}
