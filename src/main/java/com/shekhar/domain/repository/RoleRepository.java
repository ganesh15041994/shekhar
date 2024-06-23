package com.shekhar.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shekhar.domain.entities.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

	
//	select u from UserProfile u where u.emailId=:email
	@Query("Select r from Role r where r.authority=:auth")
	public Role findByAuthority(String auth);

}
