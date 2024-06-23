package com.shekhar.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shekhar.domain.entities.Role;

public interface Users_roleRepository extends JpaRepository<Role, String> {

}
