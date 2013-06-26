package com.youthministry.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

import com.youthministry.domain.User;
import com.youthministry.service.UserService;

@Component
public class SignInUtils {
	
	/**
	 * Programmatically signs in the user with the given the user ID.
	 */
	public static void signin(String userId) {
		// TODO: change third param to use custom getAuthorities method in customUserDetailsService
		ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		UserService userService = (UserService)context.getBean("UserService");
		User user = userService.getByUsername(userId);
		Authentication authentication = new UsernamePasswordAuthenticationToken(userId,null,user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);	
	}

}
