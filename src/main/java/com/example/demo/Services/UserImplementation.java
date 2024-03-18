package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.UserRepository;
import com.example.demo.entity.Users;

@Service
public class UserImplementation implements UserServices {

	@Autowired
	UserRepository repo;

	@Override
	public String addUser(Users user) {
		repo.save(user);
		return "User is created and saved";
	}

	@Override
	public boolean emailExists(String email) {
		if (repo.findByEmail(email) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean validateUser(String email, String password) {
		Users user = repo.findByEmail(email);
		String db_password = user.getPassword();
		if (db_password.equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getRole(String email) {
		return (repo.findByEmail(email).getRole());
	}

	@Override
	public Users getUser(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public void updateUser(Users user) {
		// TODO Auto-generated method stub
		repo.save(user);
	}

	@Override
	public String addadminUser(Users user) {
	 repo.save(user);
		return null;
	}

}