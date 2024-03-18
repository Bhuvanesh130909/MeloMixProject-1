package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
	
		public Users findByEmail(String email);
	}


