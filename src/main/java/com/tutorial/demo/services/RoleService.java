package com.tutorial.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.demo.dto.RoleDto;
import com.tutorial.demo.entities.Role;
import com.tutorial.demo.repositories.RoleRepo;

@Service
public class RoleService {

	@Autowired 
	private RoleRepo roleRepo;
	
	public RoleDto saveRole(RoleDto roleDto) {
		Role newRole = new Role();
		newRole.setId(roleDto.getId());
		newRole.setName(roleDto.getName());
		
		Role role = roleRepo.save(newRole);
		RoleDto roleDto1 = new RoleDto(role);		
		return roleDto1;	
	}	
}
