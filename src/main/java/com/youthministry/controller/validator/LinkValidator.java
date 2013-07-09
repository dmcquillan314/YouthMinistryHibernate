package com.youthministry.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.youthministry.domain.Link;

public class LinkValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return Link.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		Link link = (Link) command;
		if(link == null) {
			errors.rejectValue("imageName", "imageName.required", "Invalid image name");
		} else {

		}		
	}

}
