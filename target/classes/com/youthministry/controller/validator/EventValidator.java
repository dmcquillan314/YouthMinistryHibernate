package com.youthministry.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.youthministry.domain.Event;

public class EventValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return Event.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		Event event = (Event) command;
		if(event == null) {
			errors.rejectValue("eventName","eventName.required","Event name can not be empty.");
		} else {
			if(event.getEventName() == null || "".equals(event.getEventName())) {
				errors.rejectValue("eventName","eventName.required","Event name can not be empty.");
			}
			if(event.getEventDesc() == null || "".equals(event.getEventDesc())) {
				errors.rejectValue("eventDesc", "eventDesc.required", "Event description can not be empty.");
			}
			if(event.getStartTime() == null || "".equals(event.getStartTime())) {
				errors.rejectValue("startTime", "startTime.required", "Start time must be specified.");
			}
			if(event.getStartTime() != null && event.getEndTime() != null && event.getEndTime().before(event.getStartTime())) {
				errors.rejectValue("endTime", "endTime.invalidDate", "End time can not be empty or before start time.");
			}
		}
	}

}
