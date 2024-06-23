package com.shekhar.domain.services;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shekhar.domain.entities.Role;
import com.shekhar.domain.entities.User;
import com.shekhar.domain.entities.service.UserServiceModel;
import com.shekhar.domain.repository.RoleRepository;
import com.shekhar.domain.repository.UserRepository;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {

	private UserRepository userRepository;
	private ModelMapper mapper;
	private BCryptPasswordEncoder encoder;
	private RoleService roleService;

	@Autowired
	public ApplicationUserServiceImpl(UserRepository userRepository, ModelMapper mapper, BCryptPasswordEncoder encoder,
			RoleService roleService) {
		this.mapper = mapper;
		this.userRepository = userRepository;
		this.encoder = encoder;
		this.roleService = roleService;
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public UserServiceModel saveNewUser(UserServiceModel user) {

		User userEntity = mapper.map(user, User.class);

		String pass = userEntity.getPassword();
		userEntity.setPassword(encoder.encode(pass));
		Set<Role> role = new HashSet<>();

		role.add(roleService.findByAuth("ROLE_USER"));
		userEntity.setAuthorites(role);
		return this.mapper.map(this.userRepository.saveAndFlush(userEntity), UserServiceModel.class);
	}

}
