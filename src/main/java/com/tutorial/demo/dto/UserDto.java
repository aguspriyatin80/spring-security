package com.tutorial.demo.dto;

import com.tutorial.demo.entities.User;

public class UserDto {

	private int id;
	
	private String fullName;
	
	private String username;
		
	private String password;

	public UserDto(int id, String fullName, String username, String password) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.username = username;
		this.password = password;
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
		
	
}
