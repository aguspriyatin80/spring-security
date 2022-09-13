package com.tutorial.demo.dto;

import com.tutorial.demo.entities.Role;

public class RoleDto {

	private int id;
	
	private String name;

	public RoleDto() {		
	}

	public RoleDto(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public RoleDto (Role entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
