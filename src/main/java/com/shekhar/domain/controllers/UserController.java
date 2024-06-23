package com.shekhar.domain.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shekhar.domain.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@GetMapping("/profile")
	public String userProfile() {
		return "userProfile";
	}

	

}
