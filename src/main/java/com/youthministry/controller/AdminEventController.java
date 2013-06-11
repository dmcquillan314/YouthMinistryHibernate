package com.youthministry.controller;

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
public class AdminEventController {

	@Autowired
	private GroupService GroupService;
	@Autowired
	private UserService UserService;
	@Autowired
	private PageContentService PageContentService;
	@Autowired
	private EventService EventService;
	@Autowired
	private RoleService RoleService;
	@Autowired 
	private PageService PageService;

	private Validator validator;
	
	@RequestMapping(value={"/admin/updateevent/{id}"},method=RequestMethod.POST)
	public String handleUpdateEvent(@PathVariable String id, @ModelAttribute(value="eventLocation") EventLocation eventLocation, BindingResult errors, Model map) {
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("images", PageContentService.getAllImageEntries());
		map.addAttribute("textEntries", PageContentService.getAllTextEntries());
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
		map.addAttribute("pages", PageService.getPages());
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
				System.out.println(cve.getConstraintName());
			}
		}
		return "admin";
	}
	@RequestMapping(value={"/admin/createevent"},method=RequestMethod.POST)
	public String handleCreateEvent(@ModelAttribute(value="eventLocation") EventLocation eventLocation, BindingResult errors, Model map) {
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("images", PageContentService.getAllImageEntries());
		map.addAttribute("textEntries", PageContentService.getAllTextEntries());
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
		map.addAttribute("pages", PageService.getPages());
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
				System.out.println(cve.getConstraintName());
			}
		}
		return "admin";
	}
	@ModelAttribute(value="group")
	public Group getGroup() {
		return new Group();
	}
	@ModelAttribute(value="user")
	public User getUser() {
		return new User();
	}
	@ModelAttribute(value="image")
	public Image getImage() {
		return new Image();
	}
	@ModelAttribute(value="textEntry")
	public TextEntry getTextEntry() {
		return new TextEntry();
	}
	@ModelAttribute(value="eventLocation")
	public EventLocation getEventLocation() {
		return new EventLocation();
	}
		
	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyyMMddHHmmss"), true);
		binder.registerCustomEditor(Date.class, editor);
		binder.registerCustomEditor(Collection.class, "event.groups", new CustomCollectionEditor(Collection.class) {
			protected Object convertElement(Object element) {
				if(element instanceof Group) {
					System.out.println("Converting from Group to Group: " + element);
					return element;
				}
				if(element instanceof String || element instanceof Long) {
					Group group = GroupService.getGroupById(Long.parseLong((String) element));
					System.out.println("Looking up group for id " + element + ": " + group);
					return group;
				}
				System.out.println("Don't know what to do with: " + element);
				return null;
			}
		});
	}
	
	private Validator getValidator() {
		return validator;
	}

	private void setValidator(Validator validator) {
		this.validator = validator;
	}
	
}
