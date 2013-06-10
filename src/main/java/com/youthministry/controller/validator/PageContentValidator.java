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
			if(object instanceof TextEntry) {
				TextEntry textEntry = (TextEntry) object;
				if(textEntry.getLocation() == null || "".equals(textEntry.getLocation())) {
					errors.rejectValue("location", "location.required", "Invalid location.");
				}
				if(textEntry.getContentTitle() == null || "".equals(textEntry.getContentTitle())) {
					errors.rejectValue("contentTitle", "contentTitle.required", "Invalid content title.");
				}
				if(textEntry.getContentBody() == null || "".equals(textEntry.getContentBody())) {
					errors.rejectValue("contentBody", "contentBody.required", "Invalid content body.");
				}
			} else if (object instanceof Image) {
				Image image = (Image) object;
				if(image.getLocation() == null || "".equals(image.getLocation())) {
					errors.rejectValue("location", "location.required", "Invalid location.");
				}
				if(image.getPathToImage() == null || "".equals(image.getPathToImage())) {
					errors.rejectValue("pathToImage", "pathToImage.required", "Invalid image url.");
				}
				if(image.getAltText() == null || "".equals(image.getAltText())) {
					errors.rejectValue("altText", "altText.required", "Invalid image alternate text.");
				}
			}
		} else {
			errors.rejectValue("pageContentName", "pageContentName.required", "Invalid content name.");
		}
	}

}
