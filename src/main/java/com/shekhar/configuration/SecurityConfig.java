package com.shekhar.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	ModelMapper getModelMapper() {
		
		System.out.println("In Mapper");
		return new ModelMapper();
	}

	private CustomSuccessHandler customSuccessHandler;
@Autowired
	public SecurityConfig(CustomSuccessHandler customSuccessHandler) {
		this.customSuccessHandler = customSuccessHandler;
		System.out.println("Bean Created");
	}

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	UserDetailsService getUserDetail() {
		return new CustomUserDetailService();
	}

	DaoAuthenticationProvider daoAutProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(getUserDetail());
		return provider;

	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
System.out.println("In Security Filter Chain");
		http.authorizeHttpRequests((auth) -> 
						auth.mvcMatchers("/admin/**").
							hasRole("ADMIN")
									.mvcMatchers("/user/**")
										.hasRole("USER")
										.anyRequest()
										.permitAll())
		
										.formLogin((l) ->
											l.loginPage("/login")
											.loginProcessingUrl("/userLogin")
											.successHandler(customSuccessHandler)
											.permitAll())
									.logout(l ->
										l.logoutSuccessUrl("/userLogout")
										.permitAll())
										.csrf(csrf ->
										csrf.disable());
		
		
						/*
						 * http.authorizeHttpRequests((auth) ->
						 * auth.mvcMatchers("/admin/**").hasRole("ADMIN").mvcMatchers("/user/**")
						 * .hasRole("USER").anyRequest().permitAll()) .formLogin((login) ->
						 * login.loginPage("/cmnLogin").loginProcessingUrl("/userLogin")
						 * .successHandler(successHandler).permitAll()) .logout(logout ->
						 * logout.logoutSuccessUrl("/userLogout").permitAll()).csrf(csrf ->
						 * csrf.disable());
						 * 
						 * return http.build();
						 */

		return http.build();
	}

}
