package com.tutorial.demo;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tutorial.demo.entities.Role;
import com.tutorial.demo.repositories.RoleRepo;
import com.tutorial.demo.security.CustomUserDetailsService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Autowired
	private RoleRepo roleRepo;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		try {
			
			List<Role> roles = roleRepo.findAll();
			
			roles.forEach(r->{
				System.out.println(r.getName());
				
			});
			 			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
