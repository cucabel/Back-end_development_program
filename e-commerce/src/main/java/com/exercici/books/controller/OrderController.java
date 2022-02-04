package com.exercici.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercici.books.model.ApiResponse;
import com.exercici.books.model.Order;
import com.exercici.books.service.OrderService;

@CrossOrigin
@RestController
@RequestMapping("users/{userId}/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public ApiResponse<Order> saveOrder(@PathVariable int userId, @RequestBody Order order) {
		return orderService.saveOrder(userId, order);
	}

	@GetMapping("/{orderId}")
	public ApiResponse<Order> getOrder(@PathVariable int userId, @PathVariable int orderId) {
		return new ApiResponse<>(HttpStatus.OK.value(), "Order fetched successfully.", orderService.getOrder(userId, orderId));
	}
	
	@DeleteMapping("/{orderId}")
	public ApiResponse<Void> delete(@PathVariable int userId, @PathVariable int orderId) {
		return new ApiResponse<>(HttpStatus.OK.value(), "Order deleted successfully.", orderService.deleteOrder(userId, orderId));
	}
	
	@GetMapping
	public ApiResponse<List<Order>> getAllOrders(@PathVariable int userId) {
		return new ApiResponse<>(HttpStatus.OK.value(), "Orders fetched successfully.", orderService.getAllOrders(userId));
	}
	
	// query for getting the orders that have to be delivered | try getAll, instead of getAll by userId | or maybe it could be another controller for admin | or instead of putting the RequestMapping up, put it in each of the endpoints

}
