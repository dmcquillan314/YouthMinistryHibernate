package com.youthministry.security;

import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.context.ContextLoader;

import com.youthministry.domain.User;
import com.youthministry.service.UserService;

public class CustomUserDetailService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		UserService userService = (UserService)context.getBean("UserService");
		User user = userService.getByUsername(username);
		return user;
	}

}
