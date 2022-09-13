package com.tutorial.demo.dto;

import java.util.HashSet;
import java.util.Set;

import com.tutorial.demo.entities.User;

public class UserDto {

	private int id;
	
	private String fullName;
	
	private String username;
		
	private String password;
	
	private Set<RoleDto> roles = new HashSet<>();
	
	public UserDto(int id, String fullName, String username, String password, Set<RoleDto> roles) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}


	// saat ini kita belum menggunakan modelmapper, maka buat constructor ini
	public UserDto(User entity) {
        this.id = entity.getId();
        this.fullName = entity.getFullName();
        this.username= entity.getUsername();
        this.password= entity.getPassword();        
    }
	
	
	public UserDto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Set<RoleDto> getRoles() {
		return roles;
	}


	public void setRoles(Set<RoleDto> roles) {
		this.roles = roles;
	}
		
	
}
