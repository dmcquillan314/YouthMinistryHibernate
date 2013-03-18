package com.youthministry.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	@SuppressWarnings("deprecation")
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authResult)
		throws IOException, ServletException {
		super.successfulAuthentication(request, response, authResult);
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authResult;
		WebAuthenticationDetails details = (WebAuthenticationDetails) token.getDetails();
		String address = details.getRemoteAddress();
		User user = (User) authResult.getPrincipal();
		String userName = user.getUsername();
		System.out.println("**DEBUG** Seccessful login from remote address: " + address + " by username: " + userName);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed)
		throws IOException, ServletException {
		super.unsuccessfulAuthentication(request, response, failed);
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) failed.getAuthentication();
		WebAuthenticationDetails details = (WebAuthenticationDetails) token.getDetails();
		String address = details.getRemoteAddress();
		System.out.println("**DEBUG** Failed login try from remote address: " + address);
	}
}
