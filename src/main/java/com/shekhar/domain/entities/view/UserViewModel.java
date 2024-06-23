package com.shekhar.domain.entities.view;

import java.util.Set;

import com.shekhar.domain.entities.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class UserViewModel {
	
	private String id;
	private String username;
    private String password;
    private String address;
    private String email;
    private Set<Role> authorities;

}
