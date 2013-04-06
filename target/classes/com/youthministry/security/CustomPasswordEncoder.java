package com.youthministry.security;

import org.springframework.security.authentication.encoding.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder {

	@Override
	public String encodePassword(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPasswordValid(String password, String userInput, Object arg2) {
		// TODO Auto-generated method stub
		return password.equals(userInput)?true:false;
	}

}
