package com.youthministry.page.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.youthministry.domain.Page;

public class PageValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Page.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors ) {
		validatePage1Form( object, errors );
	}
	
	public void validatePage1Form( Object object, Errors errors ) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pageName", "page.pageName.required", "page name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pageUrl", "page.pageUrl.required", "page url is required");
	}
	
	public void validatePage2Form( Object object, Errors errors ) {
		
	}
	
	public void validatePage3Form( Object object, Errors errors ) {
		
	}
	
	public void validatePage4Form( Object object, Errors errors ) {
		
	}

}
