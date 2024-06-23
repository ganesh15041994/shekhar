package com.shekhar.domain.services;


import com.shekhar.domain.entities.User;
import com.shekhar.domain.entities.service.UserServiceModel;


public interface ApplicationUserService {

	public User findByEmail(String email);

	public UserServiceModel saveNewUser(UserServiceModel user);
}
