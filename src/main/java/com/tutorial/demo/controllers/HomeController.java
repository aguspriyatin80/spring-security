package com.tutorial.demo.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

	@GetMapping
	public String welcome(Authentication authentication) {
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		List<String> roles = new ArrayList<>();
		for(GrantedAuthority a : authorities) {
			roles.add(a.getAuthority());
		}

		return roles.contains("ADMIN") ? "Admin Dashboard" : "User Dashboard"; 		
				
	}
	
}
