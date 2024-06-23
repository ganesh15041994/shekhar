package com.shekhar.configuration;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {

		
		System.out.println("in success Handler");
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		System.out.println("In auth handler");
		if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
			setDefaultTargetUrl("/admin/dashbord");
		}

		else if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_USER"))) {
			setDefaultTargetUrl("/user/profile");
		}

		else {
			setDefaultTargetUrl("/");
		}
		super.onAuthenticationSuccess(request, response, authentication);
	}

	@Override
	public void setRequestCache(RequestCache requestCache) {
		// TODO Auto-generated method stub
		super.setRequestCache(requestCache);
	}

}
