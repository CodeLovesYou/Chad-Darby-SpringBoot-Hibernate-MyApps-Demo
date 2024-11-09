package com.luv2code.springbootrestsecuritydemo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
		userDetailsManager
			.setUsersByUsernameQuery("select user_id,pw,active from members where user_id=?");
		userDetailsManager
			.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id=?");
		
		return userDetailsManager;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(customizer->
			customizer
				.requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
				);
		//using HTTP basic authentication
		http.httpBasic(Customizer.withDefaults());
		
		//disable Cross Site Request Forgery(CSRF)
		http.csrf(csrf->csrf.disable());
		
		return http.build();
	}
}
