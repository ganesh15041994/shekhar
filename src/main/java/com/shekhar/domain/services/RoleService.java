package com.shekhar.domain.services;

import com.shekhar.domain.entities.Role;
public interface RoleService {
	
	public Role findByAuth(String auth);

}
