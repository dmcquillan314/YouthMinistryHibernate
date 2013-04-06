package com.youthministry.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.youthministry.domain.Event;
import com.youthministry.domain.EventLocation;
import com.youthministry.domain.Location;

public class EventValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return Event.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		EventLocation eventLocation = (EventLocation) command;
		Event event = eventLocation.getEvent();
		if(event == null) {
			errors.rejectValue("event.eventName","event.eventName.required","Event name can not be empty.");
		} else {
			if(event.getEventName() == null || "".equals(event.getEventName())) {
				errors.rejectValue("event.eventName","event.eventName.required","Event name can not be empty.");
			}
			if(event.getEventDesc() == null || "".equals(event.getEventDesc())) {
				errors.rejectValue("event.eventDesc", "event.eventDesc.required", "Event description can not be empty.");
			}
			if(event.getStartTime() == null || "".equals(event.getStartTime())) {
				errors.rejectValue("event.startTime", "event.startTime.required", "Start time must be specified.");
			}
			if(event.getStartTime() != null && event.getEndTime() != null && event.getEndTime().before(event.getStartTime())) {
				errors.rejectValue("event.endTime", "event.endTime.invalidDate", "End time can not be empty or before start time.");
			}
		}
		
		Location location = eventLocation.getLocation();
		if(location == null) {
			errors.rejectValue("location.locationName","location.locationName.required","You must enter a name for the location.");
		} else {
			if(location.getLocationName() == null || "".equals(location.getStreet())) {
				errors.rejectValue("location.locationName","location.locationName.required","You must enter a name for the location.");
			}
			if(location.getStreet() == null || "".equals(location.getStreet())) {
				errors.rejectValue("location.street","location.street.required","You must enter a street for the location.");
			}
			if(location.getCity() == null || "".equals(location.getCity())) {
				errors.rejectValue("location.city","location.city.required","You must enter a city for the location.");				
			}
			if(location.getState() == null || "".equals(location.getState())) {
				errors.rejectValue("location.state","location.state.required","You must enter a state for the location.");
			}
			if(location.getZipcode() == null || "".equals(location.getZipcode())) {				
				errors.rejectValue("location.zipcode","location.zipcode.required","You must enter a zipcode for the location.");
			}
			if(location.getCountry() == null || "".equals(location.getCountry())) {
				errors.rejectValue("location.country","location.country.required","You must enter a country for the location.");
			}
		}
	}

}
