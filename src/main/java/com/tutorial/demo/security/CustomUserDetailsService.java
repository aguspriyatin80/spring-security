package com.tutorial.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.tutorial.demo.entities.User;
import com.tutorial.demo.repositories.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepo userRepo;
	
		
	@Override
	public UserDetails loadUserByUsername(String username) {
		
		User user = userRepo.findByUsername(username);
		
		return user;
		
	}
}
