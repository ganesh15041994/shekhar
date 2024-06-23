package com.shekhar.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.shekhar.domain.entities.User;
import com.shekhar.domain.services.ApplicationUserService;
import com.shekhar.domain.services.UserServiceImpl;

@Component
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private ApplicationUserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByEmail(username);
		
		System.out.println("in userdetail");
		if (user != null) {
			return new CutsomUser(user);
		} else {
			throw new UsernameNotFoundException("user not exists");
		}

	}

}
