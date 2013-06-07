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
import com.youthministry.controller.validator.GroupValidator;
import com.youthministry.controller.validator.PageContentValidator;
import com.youthministry.domain.Event;
import com.youthministry.domain.EventLocation;
import com.youthministry.domain.Group;
import com.youthministry.domain.Image;
import com.youthministry.domain.Location;
import com.youthministry.domain.TextEntry;
import com.youthministry.domain.User;
import com.youthministry.domain.Role;
import com.youthministry.service.GroupService;
import com.youthministry.service.UserService;
import com.youthministry.service.PageContentService;
import com.youthministry.service.EventService;
import com.youthministry.service.RoleService;

@Controller
public class AdminController {

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
	
	private Validator validator;
	
	@RequestMapping(value={"/admin"},method=RequestMethod.GET)
	public String admin(Model map) {
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("images", PageContentService.getAllImageEntries());
		map.addAttribute("textEntries", PageContentService.getAllTextEntries());
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
		return "admin";
	}
		
	@RequestMapping(value={"/admin/updateuser/{id}"},method=RequestMethod.POST)
	public String handleUpdateUser(@PathVariable String id, @ModelAttribute(value="user") User user, BindingResult errors, Model map) {
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("images", PageContentService.getAllImageEntries());
		map.addAttribute("textEntries", PageContentService.getAllTextEntries());
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
		user.setUserId(Long.parseLong(id));
		if(!errors.hasErrors()) {
			try {
				UserService.updateUser(user);
				return "redirect:/admin";
			} catch(ConstraintViolationException cve) {
				System.out.println(cve.getConstraintName());
			}
		}
		return "admin";
	}
	
	@RequestMapping(value={"/admin/creategroup"},method=RequestMethod.POST)
	public String handleCreateGroup(@ModelAttribute(value="group") Group group, BindingResult errors, Model map) {
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("images", PageContentService.getAllImageEntries());
		map.addAttribute("textEntries", PageContentService.getAllTextEntries());
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
		this.setValidator(new GroupValidator());
		this.getValidator().validate(group, errors);
		if(! errors.hasErrors()) {
			try {
				GroupService.addGroup(group);
				return "redirect:/admin";
			} catch(ConstraintViolationException cve) {
				errors.rejectValue("groupName", "groupName.duplicate", "This group name is already in use.");
				System.out.println(cve.getConstraintName());
			}
		}
		return "admin";
	}
	
	@RequestMapping(value={"/admin/updategroup/{id}"},method=RequestMethod.POST)
	public String handleUpdateUser(@PathVariable String id, @ModelAttribute(value="group") Group group, BindingResult errors, Model map) {
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("images", PageContentService.getAllImageEntries());
		map.addAttribute("textEntries", PageContentService.getAllTextEntries());
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
		this.setValidator(new GroupValidator());
		this.getValidator().validate(group, errors);
		group.setGroupId(Long.parseLong(id));
		if(! errors.hasErrors()) {
			try {
				GroupService.updateGroup(group);
				return "redirect:/admin";
			} catch(ConstraintViolationException cve) {
				errors.rejectValue("groupName", "groupName.duplicate", "This group name is already in use.");
				System.out.println(cve.getConstraintName());
			}
		}
		return "admin";
	}
	@RequestMapping(value={"/admin/updateimage/{id}"},method=RequestMethod.POST)
	public String handleUpdateImage(@PathVariable String id, @ModelAttribute(value="image") Image image, BindingResult errors, Model map) {
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("images", PageContentService.getAllImageEntries());
		map.addAttribute("textEntries", PageContentService.getAllTextEntries());
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
		this.setValidator(new PageContentValidator());
		this.getValidator().validate(image, errors);
		image.setPageContentId(Long.parseLong(id));
		if(! errors.hasErrors()) {
			try {
				PageContentService.updatePageContent(image);
				return "redirect:/admin";
			} catch(ConstraintViolationException cve) {
				errors.rejectValue("pageContentName", "pageContentName.duplicate", "This page content is already in use.");
				System.out.println(cve.getConstraintName());
			}
		}
		return "admin";
	}

	@RequestMapping(value={"/admin/createimage"},method=RequestMethod.POST)
	public String handleCreateImage(@ModelAttribute(value="image") Image image, BindingResult errors, Model map) {
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("images", PageContentService.getAllImageEntries());
		map.addAttribute("textEntries", PageContentService.getAllTextEntries());
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
		this.setValidator(new PageContentValidator());
		this.getValidator().validate(image, errors);
		if(! errors.hasErrors()) {
			try {
				//System.out.println()
				PageContentService.addPageContent(image);
				return "redirect:/admin";
			} catch(ConstraintViolationException cve) {
				errors.rejectValue("pageContentName", "pageContentName.duplicate", "This page content name is already in use.");
				System.out.println(cve.getConstraintName());
			}
		}
		return "admin";
	}
	@RequestMapping(value={"/admin/updatetextentry/{id}"},method=RequestMethod.POST)
	public String handleUpdateTextEntry(@PathVariable String id, @ModelAttribute(value="textEntry") TextEntry textEntry, BindingResult errors, Model map) {
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("images", PageContentService.getAllImageEntries());
		map.addAttribute("textEntries", PageContentService.getAllTextEntries());
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
		this.setValidator(new PageContentValidator());
		this.getValidator().validate(textEntry, errors);
		textEntry.setPageContentId(Long.parseLong(id));
		if(! errors.hasErrors()) {
			try {
				PageContentService.updatePageContent(textEntry);
				return "redirect:/admin";
			} catch(ConstraintViolationException cve) {
				errors.rejectValue("pageContentName", "pageContentName.duplicate", "This page content is already in use.");
				System.out.println(cve.getConstraintName());
			}
		}
		return "admin";
	}
	@RequestMapping(value={"/admin/createtextentry"},method=RequestMethod.POST)
	public String handleCreateTextEntry(@ModelAttribute(value="textEntry") TextEntry textEntry, BindingResult errors, Model map) {
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("images", PageContentService.getAllImageEntries());
		map.addAttribute("textEntries", PageContentService.getAllTextEntries());
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
		this.setValidator(new PageContentValidator());
		this.getValidator().validate(textEntry, errors);
		if(! errors.hasErrors()) {
			try {
				PageContentService.addPageContent(textEntry);
				return "redirect:/admin";
			} catch(ConstraintViolationException cve) {
				errors.rejectValue("pageContentName", "pageContentName.duplicate", "This page content is already in use.");
				System.out.println(cve.getConstraintName());
			}
		}
		return "admin";
	}
	@RequestMapping(value={"/admin/updateevent/{id}"},method=RequestMethod.POST)
	public String handleUpdateEvent(@PathVariable String id, @ModelAttribute(value="eventLocation") EventLocation eventLocation, BindingResult errors, Model map) {
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("images", PageContentService.getAllImageEntries());
		map.addAttribute("textEntries", PageContentService.getAllTextEntries());
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
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
		binder.registerCustomEditor(Collection.class, "groups", new CustomCollectionEditor(Collection.class) {
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
		binder.registerCustomEditor(Collection.class, "roles", new CustomCollectionEditor(Collection.class) {
			protected Object convertElement(Object element) {
				if(element instanceof Role) {
					System.out.println("Converting from Role to Role: " + element);
					return element;
				}
				if(element instanceof String || element instanceof Long) {
					Role role = RoleService.getRoleById(Long.parseLong((String) element));
					System.out.println("Looking up role for id " + element + ": " + role);
					return role;
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
