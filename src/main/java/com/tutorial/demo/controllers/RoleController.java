package com.tutorial.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.demo.dto.RoleDto;
import com.tutorial.demo.services.RoleService;

@RestController
@RequestMapping("/api/v1")
public class RoleController {

	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/roles")
	public ResponseEntity<RoleDto> saveRole(@RequestBody RoleDto roleDto){
		
		RoleDto newRole = roleService.saveRole(roleDto);
		
		return new ResponseEntity<RoleDto>(newRole,HttpStatus.CREATED);
	}
		
		
}
	
