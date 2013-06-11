package com.youthministry.controller;

import java.util.Collection;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
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

import com.youthministry.controller.validator.PageContentValidator;
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
public class AdminPageContentController {

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
	
	@RequestMapping(value={"/admin/updateimage/{id}"},method=RequestMethod.POST)
	public String handleUpdateImage(@PathVariable String id, @ModelAttribute(value="image") Image image, BindingResult errors, Model map) {
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("images", PageContentService.getAllImageEntries());
		map.addAttribute("textEntries", PageContentService.getAllTextEntries());
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
		map.addAttribute("pages", PageService.getPages());
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
		map.addAttribute("pages", PageService.getPages());
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
	}
	
	private Validator getValidator() {
		return validator;
	}

	private void setValidator(Validator validator) {
		this.validator = validator;
	}
	
}
