package com.shekhar.domain.entities.service;

import java.util.HashSet;
import java.util.Set;

import com.shekhar.domain.entities.Role;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class UserServiceModel extends BaseServiceModel {

	private String username;
	private String email;
	private String password;
	private String address;
	private Set<Role> authorites;

	public UserServiceModel() {
		this.authorites = new HashSet<>();
	}

}
