package com.tutorial.demo.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.tutorial.demo.dto.UserDto;
import com.tutorial.demo.entities.User;
import com.tutorial.demo.repositories.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired		
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;	
	
	// jika menggunakan model mapper gunakan method ini 
	public UserDto registerNewUser(UserDto req) {
		User user = modelMapper.map(req, User.class);
		user.setPassword(passwordEncoder.encode(user.getPassword()));		
		User newUser = userRepo.save(user);
		
		return modelMapper.map(newUser, UserDto.class);
	}
	
	// jika tidak menggunakan model mapper gunakan method ini dan tambahkan juga kode di UserDto
	public UserDto saveUser(UserDto userDto) {
		User newUser = new User();
		newUser.setId(userDto.getId());
		newUser.setFullName(userDto.getFullName());
		newUser.setUsername(userDto.getUsername());
		newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
		
		User user = userRepo.save(newUser);
		UserDto userDto1 = new UserDto(user);
		return userDto1;	
	}	
}
