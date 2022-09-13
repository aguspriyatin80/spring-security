package com.tutorial.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.demo.dto.UserDto;
import com.tutorial.demo.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	User findByUsername(String username);

	UserDto save(UserDto registerDto);
	
	User findByFullName(String fullName);
	
}
