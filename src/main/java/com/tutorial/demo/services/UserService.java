package com.tutorial.demo.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tutorial.demo.dto.UserDto;
import com.tutorial.demo.entities.Role;
import com.tutorial.demo.entities.User;
import com.tutorial.demo.repositories.RoleRepo;
import com.tutorial.demo.repositories.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired		
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;	
	
	// jika menggunakan model mapper gunakan method ini 
//	public UserDto registerNewUser(UserDto req) {
//		User user = modelMapper.map(req, User.class);
//		user.setPassword(passwordEncoder.encode(user.getPassword()));		
//		User newUser = userRepo.save(user);
//		
//		return modelMapper.map(newUser, UserDto.class);
//	}
		
	public UserDto saveUserWithDefaultRole(UserDto req) {
		User newUser = modelMapper.map(req, User.class);
		newUser.setPassword(passwordEncoder.encode(req.getPassword()));		
		
		Role role = roleRepo.findById(1).get();		
		newUser.getRoles().add(role);	
		userRepo.save(newUser);
		return modelMapper.map(newUser, UserDto.class);
	}
	
}
