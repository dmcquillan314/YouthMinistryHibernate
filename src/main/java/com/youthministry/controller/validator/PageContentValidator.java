package com.youthministry.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.youthministry.domain.Image;
import com.youthministry.domain.PageContent;
import com.youthministry.domain.TextEntry;

public class PageContentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Image.class.isAssignableFrom(clazz) || TextEntry.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		if(object != null) {
			if(((PageContent) object).getPageContentName() == null || "".equals(((PageContent) object).getPageContentName())) {
				errors.rejectValue("pageContentName", "pageContentName.required", "Invalid content name.");
			}
		} else {
			errors.rejectValue("pageContentName", "pageContentName.required", "Invalid content name.");
		}
	}

}
