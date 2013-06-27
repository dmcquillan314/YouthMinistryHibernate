package com.youthministry.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.youthministry.domain.Group;

public class GroupValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return Group.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		Group group = (Group) command;
		if(group == null) {
			errors.rejectValue("groupName","groupName.required", "Invalid group name.");
		} 
		if (group.getGroupName() == null || "".equals(group.getGroupName())) {
			errors.rejectValue("groupName","groupName.required", "Invalid group name.");
		}
	}

}
