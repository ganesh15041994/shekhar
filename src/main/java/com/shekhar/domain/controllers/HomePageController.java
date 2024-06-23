package com.shekhar.domain.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shekhar.domain.entities.User;
import com.shekhar.domain.entities.binding.UserRegisterBindingModel;
import com.shekhar.domain.entities.service.UserServiceModel;
import com.shekhar.domain.services.ApplicationUserService;

@Controller
public class HomePageController extends BaseController {

	private ApplicationUserService applicationUserService;
	@Autowired
	private ModelMapper mapper;

	@Autowired
	public HomePageController(ApplicationUserService applicationUserService) {
		this.applicationUserService = applicationUserService;

	}

	@GetMapping("/")
	public String getHome() {
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public ModelAndView registerNewUser(@ModelAttribute(name = "model") UserRegisterBindingModel model,
			ModelAndView modelAndView) {

		modelAndView.addObject("model", model);

		return view("register", modelAndView);
	}

	@PostMapping("/register")
	public ModelAndView saveUser(@Valid @ModelAttribute(name = "model") UserRegisterBindingModel model,
			ModelAndView modelView, BindingResult bindingResult) {

		if (!model.getPassword().equals(model.getConfirmPassword()) || bindingResult.hasErrors()
				|| this.applicationUserService.saveNewUser(this.mapper.map(model, UserServiceModel.class)) == null) {
			modelView.addObject("model", model);
			/* */
			System.out.println("something went wrong");

			System.out.println(bindingResult.hasFieldErrors("password"));
			return view("register", modelView);
		}

		System.out.println(model);
		return redirect("login");
	}

	@ModelAttribute
	public void commanUser(Principal principal, Model model) {
		System.out.println("In Principle ");
		//System.out.println(principal.getName()+"in pric");
		if (principal != null) {
			System.out.println("Iner block of Principle");
			String email = principal.getName();
			User user = applicationUserService.findByEmail(email);
			model.addAttribute("user", user);
		}
	}
}
