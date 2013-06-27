package com.youthministry.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.youthministry.domain.Image;

public class ImageValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return Image.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		Image image = (Image) command;
		if(image == null) {
			errors.rejectValue("imageName", "imageName.required", "Invalid image name");
		} else {
			if(image.getImageName() == null || "".equals(image.getImageName())) {				
				errors.rejectValue("imageName", "imageName.required", "Invalid image name");
			}
		}
	}

}
