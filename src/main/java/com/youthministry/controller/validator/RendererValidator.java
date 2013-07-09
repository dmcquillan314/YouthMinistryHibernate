package com.youthministry.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.youthministry.domain.Renderer;

public class RendererValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		// TODO Auto-generated method stub
		return Renderer.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		Renderer renderer = (Renderer) command;
		if(renderer == null) {
			errors.rejectValue("imageName", "imageName.required", "Invalid image name");
		} else {
			
		}
	}

}
