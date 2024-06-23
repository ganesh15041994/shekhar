package com.shekhar.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shekhar.domain.entities.Role;
import com.shekhar.domain.entities.User;
import com.shekhar.domain.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	private RoleRepository roleRepository;

	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public Role findByAuth(String auth) {

		// TODO Auto-generated method stub
		return this.roleRepository.findByAuthority(auth);
	}

}
