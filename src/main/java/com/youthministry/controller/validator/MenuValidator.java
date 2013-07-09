package com.youthministry.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.youthministry.domain.Menu;

public class MenuValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return Menu.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		Menu menu = (Menu) command;
		if(menu == null) {
			errors.rejectValue("imageName", "imageName.required", "Invalid image name");
		} else {

		}		
	}

}
