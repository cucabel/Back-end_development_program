package com.exercici.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercici.books.model.ApiResponse;
import com.exercici.books.model.LineItem;
import com.exercici.books.model.User;
import com.exercici.books.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/signup")
	public ApiResponse<User> saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping("/{userId}")
	public ApiResponse<User> getOne(@PathVariable int userId) {
		return userService.getOne(userId);
	}

	@PutMapping("/{userId}")
	public ApiResponse<User> updateUserPassword(@PathVariable int userId, @RequestBody User user) {
		return new ApiResponse<>(HttpStatus.OK.value(), "Password changed successfully.", userService.updateUserPassword(userId, user));
	}

	@DeleteMapping("/{userId}")
	public ApiResponse<Void> delete(@PathVariable int userId) {
		return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "User deleted successfully.", userService.delete(userId));
	}
	
	@PutMapping("/{userId}/addBook")
	public ApiResponse<User> addBook(@PathVariable int userId, @RequestBody LineItem lineItem) { 
		return new ApiResponse<>(HttpStatus.OK.value(), "Book added successfully.", userService.addBook(userId, lineItem));
	}
	
	@PutMapping("/{userId}/deleteLineItem")
	public ApiResponse<User> deleteLineItem(@PathVariable int userId, @RequestBody LineItem lineItem) {
		return new ApiResponse<>(HttpStatus.OK.value(), "LineItem deleted successfully.", userService.deleteLineItem(userId, lineItem));
	}
	
	@PutMapping("/{userId}/updateCart")
	public ApiResponse<User> updateCart(@PathVariable int userId, @RequestBody List<LineItem> cart) { // pass it as Object, as you did in dice or pictures
		return new ApiResponse<>(HttpStatus.OK.value(), "Cart updated successfully.", userService.updateCart(userId, cart));
	}

	@GetMapping
	public ApiResponse<List<User>> listUsers() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Users fetched successfully.", userService.listUsers());
	}

}
