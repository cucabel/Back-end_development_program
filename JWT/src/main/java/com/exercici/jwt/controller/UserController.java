package com.exercici.jwt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercici.jwt.model.ApiResponse;
import com.exercici.jwt.model.User;
import com.exercici.jwt.repository.IUsersRepository;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	IUsersRepository iUsersRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	
    @PostMapping(value = "/signup")
    public ApiResponse<User> saveUser(@RequestBody User user){
    	String encriptedPassword = bcryptEncoder.encode(user.getPassword());
    	user.setPassword(encriptedPassword);
    	return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.", iUsersRepository.save(user));
    }

    @GetMapping
    public ApiResponse<List<User>> listUser(){
		List<User> list = new ArrayList<>();    	
		iUsersRepository.findAll().iterator().forEachRemaining(list::add);
        return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.", list);
    }

    @GetMapping("/{id}")
    public ApiResponse<User> getOne(@PathVariable int id){
		Optional<User> optionalUser = iUsersRepository.findById(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.", optionalUser.isPresent() ? optionalUser.get() : null);
    }

    @PutMapping("/{id}")
    public ApiResponse<User> update(@PathVariable int id, @RequestBody User user) {    	
        Optional<User> userToUpdate = iUsersRepository.findById(id);       
        if(user != null) {
            BeanUtils.copyProperties(user, userToUpdate, "password");
        }
        return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully.", iUsersRepository.save(userToUpdate.get()));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable int id) {
    	iUsersRepository.deleteById(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.", null);
    }

}
