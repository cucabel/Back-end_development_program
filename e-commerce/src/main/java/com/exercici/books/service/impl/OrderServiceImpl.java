package com.exercici.books.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.exercici.books.model.ApiResponse;
import com.exercici.books.model.Order;
import com.exercici.books.model.User;
import com.exercici.books.repository.IBookRepository;
import com.exercici.books.repository.IOrderRepository;
import com.exercici.books.repository.IUserRepository;
import com.exercici.books.service.OrderService;

@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private IOrderRepository orderRepository;
	@Autowired
	private IBookRepository bookRepository;

	@Override
	public ApiResponse<Order> saveOrder(int userId, Order order) {
		
		Optional<User> optionalUser = userRepository.findById(userId);
		
		if (optionalUser.isPresent()) {
			order.getLineItemsList().forEach(l -> bookRepository.findById(l.getBook().getId()).get().restCopy(l.getQuantity()));
			return new ApiResponse<>(HttpStatus.OK.value(), "Order saved successfully.", orderRepository.save(new Order(order.getLineItemsList(), optionalUser.get())));
		} else 
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "User not fetched successfully.", null);
		
	}
	
	@Override
	public ApiResponse<Order> getOrder(int userId, int orderId) {
		
		User user = userRepository.findById(userId).get();
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		
		return optionalOrder.isPresent() 
				? new ApiResponse<>(HttpStatus.FOUND.value(), "Order fetched successfully", orderRepository.findByIdAndUser(orderId, user))
				: new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "The order doesn't exist", null);
	}
	
	@Override
	public Void deleteOrder(int userId, int orderId) {
		
		orderRepository.getOne(orderId).getLineItemsList().forEach(l -> l.getBook().addCopy(l.getQuantity()));
		
		orderRepository.deleteByIdAndUser(orderId, userRepository.findById(userId).get());
		return null;
	}

	@Override
	public List<Order> getAllOrders(int userId) {
		return orderRepository.findAllByUser(userRepository.findById(userId).get());
	}

}
