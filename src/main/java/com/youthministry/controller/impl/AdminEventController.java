package com.youthministry.controller.impl;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.youthministry.controller.AbstractAdminController;
import com.youthministry.controller.validator.EventValidator;
import com.youthministry.domain.Event;
import com.youthministry.domain.EventLocation;
import com.youthministry.domain.Group;
import com.youthministry.domain.Image;
import com.youthministry.domain.TextEntry;
import com.youthministry.domain.User;
import com.youthministry.service.GroupService;
import com.youthministry.service.UserService;
import com.youthministry.service.PageContentService;
import com.youthministry.service.EventService;
import com.youthministry.service.RoleService;
import com.youthministry.service.PageService;

@Controller
public class AdminEventController extends AbstractAdminController {

	@Override
	@RequestMapping(value={"/admin/createevent"},method=RequestMethod.POST)
	public String handleCreate(@ModelAttribute(value="eventLocation") Object object, BindingResult errors,
			Model map) {
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("contentItems", PageContentService.getAllPageContent());
		map.addAttribute("images", PageContentService.getAllImageEntries());
		map.addAttribute("textEntries", PageContentService.getAllTextEntries());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
		map.addAttribute("pages", PageService.getPages());
		EventLocation eventLocation = (EventLocation) object;
		this.setValidator(new EventValidator());
		this.getValidator().validate(eventLocation, errors);
		if(! errors.hasErrors()) {
			Event event = eventLocation.getEvent();
			event.setLocation(eventLocation.getLocation());
			try {
				EventService.addEvent(event);
				return "redirect:/admin";
			} catch(ConstraintViolationException cve) {
				errors.rejectValue("groupName", "groupName.unknownError","An error occurred while processing your request.");
			}
		}
		return "admin";
	}
	
	@Override
	@RequestMapping(value={"/admin/updateevent/{id}"},method=RequestMethod.POST)
	public String handleUpdate(@PathVariable String id, @ModelAttribute(value="eventLocation") Object object, BindingResult errors,
			Model map) {
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("contentItems", PageContentService.getAllPageContent());
		map.addAttribute("images", PageContentService.getAllImageEntries());
		map.addAttribute("textEntries", PageContentService.getAllTextEntries());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
		map.addAttribute("pages", PageService.getPages());
		EventLocation eventLocation = (EventLocation) object;
		this.setValidator(new EventValidator());
		this.getValidator().validate(eventLocation, errors);
		eventLocation.getEvent().setEventId(Long.parseLong(id));
		if(! errors.hasErrors()) {
			Event event = eventLocation.getEvent();
			event.setLocation(eventLocation.getLocation());
			try {
				EventService.addEvent(event);
				return "redirect:/admin";
			} catch(ConstraintViolationException cve) {
				errors.rejectValue("groupName", "groupName.unknownError","An error occurred while processing your request.");
			}
		}
		return "admin";
	}
	
	@Override
	@RequestMapping(value={"/admin/deleteevent"},method=RequestMethod.POST)
	public String handleDelete(@PathVariable String id) {
		// TODO Auto-generated method stub
		return null;
	}
		
	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyyMMddHHmmss"), true);
		binder.registerCustomEditor(Date.class, editor);
		binder.registerCustomEditor(Collection.class, "event.groups", new CustomCollectionEditor(Collection.class) {
			protected Object convertElement(Object element) {
				if(element instanceof Group) {
					return element;
				}
				if(element instanceof String || element instanceof Long) {
					Group group = GroupService.getGroupById(Long.parseLong((String) element));
					return group;
				}
				return null;
			}
		});
	}
		
}
