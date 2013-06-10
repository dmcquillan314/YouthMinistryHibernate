package com.youthministry.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.youthministry.domain.Page;

public class PageValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Page.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		if(object != null) {
			Page page = (Page) object;
			if(page.getPageName() != null && !"".equals(page.getPageName())) {
				errors.rejectValue("pageName", "pageName.required", "Invalid page name");
			} else if(page.getPageURL() != null && !"".equals(page.getPageURL())) {
				errors.rejectValue("pageUrl", "pageUrl.required", "Invalid page url");				
			}
		} else {
			errors.rejectValue("pageName", "pageName.required", "Invalid page name");
		}
	}

}
