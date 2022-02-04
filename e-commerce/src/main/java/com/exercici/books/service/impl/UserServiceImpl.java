package com.exercici.books.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.exercici.books.model.ApiResponse;
import com.exercici.books.model.LineItem;
import com.exercici.books.model.User;
import com.exercici.books.repository.IUserRepository;
import com.exercici.books.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private IUserRepository userRepository;
		
	@Override
	public ApiResponse<User> saveUser(User user) {
		
		User existingUser = userRepository.findByNickName(user.getNickName());
		
		if (existingUser != null)
			return new ApiResponse<>(HttpStatus.OK.value(), "The name is not available", null);
		
		existingUser = userRepository.findByUserName(user.getUserName());

		if (existingUser != null)
			return new ApiResponse<>(HttpStatus.OK.value(), "The email already exists", null);
		
		return new ApiResponse<>(HttpStatus.OK.value(), "User successfully created", userRepository.save(user));
		
	}

	@Override
	public ApiResponse<User> getOne(int userId) {
		
		Optional<User> optionalUser = userRepository.findById(userId);
					
		return optionalUser.isPresent() 
				? new ApiResponse<>(HttpStatus.FOUND.value(), "User fetched successfully", optionalUser.get()) 
				: new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "The user doesn't exist", null);
	}

	@Override
	public User updateUserPassword(int userId, User user) {
		User userToUpdate = userRepository.findById(userId).get();
		userToUpdate.setPassword(user.getPassword());
		return userRepository.save(userToUpdate);
	}

	@Override
	public Void delete(int userId) {
		userRepository.deleteById(userId);
		return null;
	}
	
	@Override
	public User addBook(int userId, LineItem lineItem) {
				
		User user = userRepository.findById(userId).get();
		List<LineItem> cart = user.getCart();
		int bookId = lineItem.getBook().getId();
		
		Boolean existing = false;
		
		for (LineItem l : cart) {
			
			if (l.getBook().getId() == bookId) {
				existing = true;
				l.setQuantity(l.getQuantity() + lineItem.getQuantity());
				break;
			}
		}
		
		if (!existing)
			cart.add(lineItem);
		
		user.setCart(cart);
		return userRepository.save(user);
	}
	
	@Override
	public User deleteLineItem(int userId, LineItem lineItem) {
		
		User user = userRepository.findById(userId).get();
		List<LineItem> cart = user.getCart();
		
		cart.removeIf(l -> l.getBook().getId() == lineItem.getBook().getId());
		
		user.setCart(cart);
		return userRepository.save(user);		

	}

	// the books that are ordered are added to the order, and the ones that aren't ordered, are added to the cart, remain in the cart
	@Override
	public User updateCart(int userId, List<LineItem> cart) {
		
		User user = userRepository.findById(userId).get();
		user.setCart(cart);

		return userRepository.save(user);		
	}
	
	@Override
	public List<User> listUsers() {
		return userRepository.findAll();
	}

}		
