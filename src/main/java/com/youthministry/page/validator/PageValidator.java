package com.youthministry.page.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.youthministry.domain.Page;


public class PageValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Page.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
	}

}
