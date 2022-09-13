package com.tutorial.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.demo.dto.RoleDto;
import com.tutorial.demo.entities.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role,Integer> {

	RoleDto save(RoleDto roleDto);
}
