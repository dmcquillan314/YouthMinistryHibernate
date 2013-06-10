package com.youthministry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.youthministry.domain.EventLocation;
import com.youthministry.domain.Group;
import com.youthministry.domain.Image;
import com.youthministry.domain.Page;
import com.youthministry.domain.TextEntry;
import com.youthministry.domain.User;
import com.youthministry.service.GroupService;
import com.youthministry.service.UserService;
import com.youthministry.service.PageService;
import com.youthministry.service.PageContentService;
import com.youthministry.service.EventService;
import com.youthministry.service.RoleService;

@Controller
public class AdminController {

	@Autowired
	private GroupService GroupService;
	@Autowired
	private PageService PageService;
	@Autowired
	private UserService UserService;
	@Autowired
	private PageContentService PageContentService;
	@Autowired
	private EventService EventService;
	@Autowired
	private RoleService RoleService;
	
	
	@RequestMapping(value={"/admin"},method=RequestMethod.GET)
	public String admin(Model map) {
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("images", PageContentService.getAllImageEntries());
		map.addAttribute("textEntries", PageContentService.getAllTextEntries());
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
		map.addAttribute("pages", PageService.getPages());
		return "admin";
	}
		
	@ModelAttribute(value="group")
	public Group getGroup() {
		return new Group();
	}
	@ModelAttribute(value="page")
	public Page getPage() {
		return new Page();
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
	
}
