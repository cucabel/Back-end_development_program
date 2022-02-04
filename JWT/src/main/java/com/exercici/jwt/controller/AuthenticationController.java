package com.exercici.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercici.jwt.model.AuthenticationRequest;
import com.exercici.jwt.util.JwtUtil;

@CrossOrigin
@RestController
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager; 
	
	@Autowired
	private JwtUtil jwtTokenUtil;
		
	@PostMapping("/generate-token") // login
	public String createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception { 
		
		try {
			authenticationManager.authenticate( 
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword())); 
		} catch (Exception ex) {
			throw new Exception("Incorrect username or password");
		}
		
		return jwtTokenUtil.generateToken(authenticationRequest.getUserName()); 
		
	} 
	
}
