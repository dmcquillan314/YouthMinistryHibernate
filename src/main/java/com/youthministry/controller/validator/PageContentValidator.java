package com.youthministry.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.youthministry.domain.PageContent;

public class PageContentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PageContent.class.isAssignableFrom(clazz);
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
