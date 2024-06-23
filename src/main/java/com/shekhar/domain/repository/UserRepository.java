package com.shekhar.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shekhar.domain.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

	public User findByEmail(String email);
	

}
