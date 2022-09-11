package com.tutorial.demo.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.demo.dto.UserDto;
import com.tutorial.demo.repositories.UserRepo;
import com.tutorial.demo.security.CustomUserDetailsService;
import com.tutorial.demo.security.JwtAuthRequest;
import com.tutorial.demo.security.JwtAuthResponse;
import com.tutorial.demo.security.JwtTokenHelper;
import com.tutorial.demo.services.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepo userRepo;
	
	@PostMapping("/login") 
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception{
		authenticate(request.getUsername(), request.getPassword());		
		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
		
		String token = jwtTokenHelper.generateToken(userDetails);
		
		JwtAuthResponse response = new JwtAuthResponse();
		response.setToken(token);
		System.out.print(request.getUsername());
		return new ResponseEntity<JwtAuthResponse>(response,HttpStatus.OK);			
		
	 }

	private void authenticate(String username, String password) throws Exception{
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
		
		try {
			authenticationManager.authenticate(authenticationToken);
		} catch(BadCredentialsException e) {
			System.out.println("Invalid dentials");
			throw new Exception("Invalid username or password");
		}		
	}
	
		
	@PostMapping("/register")
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto user){
		
		UserDto newUser = userService.saveUser(user);
		
		return new ResponseEntity<>(newUser,HttpStatus.CREATED);
	}
	
	@PostMapping("/register2")
	public ResponseEntity<UserDto> registerUser2(@RequestBody UserDto userDto){
		
		UserDto newUser = userService.registerNewUser(userDto);
		
		return new ResponseEntity<UserDto>(newUser,HttpStatus.CREATED);
	}
		
}
