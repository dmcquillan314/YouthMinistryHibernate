package com.youthministry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.youthministry.domain.Event;
import com.youthministry.domain.EventLocation;
import com.youthministry.domain.Group;
import com.youthministry.domain.Image;
import com.youthministry.domain.Page;
import com.youthministry.domain.Role;
import com.youthministry.domain.TextEntry;
import com.youthministry.domain.User;
import com.youthministry.service.GroupService;
import com.youthministry.service.ImageService;
import com.youthministry.service.UserService;
import com.youthministry.service.PageService;
import com.youthministry.service.PageContentService;
import com.youthministry.service.EventService;
import com.youthministry.service.RoleService;

public abstract class AbstractAdminController {

	@Autowired
	protected GroupService GroupService;
	@Autowired
	protected PageService PageService;
	@Autowired
	protected UserService UserService;
	@Autowired
	protected PageContentService PageContentService;
	@Autowired
	protected EventService EventService;
	@Autowired
	protected RoleService RoleService;
	@Autowired
	protected ImageService ImageService;
	
	protected Validator validator;

	public Validator getValidator() {
		return this.validator;
	}
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	public abstract String handleUpdate(String id, Object object, BindingResult errors, Model map);
	
	public abstract String handleCreate(Object object, BindingResult errors, Model map);
	
	public abstract String handleDelete(String id);

	@ModelAttribute(value="user")
	public User getUser() {
		return new User();
	}
	@ModelAttribute(value="group")
	public Group getGroup() {
		return new Group();
	}
	@ModelAttribute(value="image")
	public Image getImage() {
		return new Image();
	}
	@ModelAttribute(value="pageContent")
	public TextEntry getTextEntry() {
		return new TextEntry();
	}
	@ModelAttribute(value="event")
	public Event getEvent() {
		return new Event();
	}
	@ModelAttribute(value="eventLocation")
	public EventLocation getEventLocation() {
		return new EventLocation();
	}
	@ModelAttribute(value="role")
	public Role getRole() {
		return new Role();
	}
	@ModelAttribute(value="page")
	public Page getPage() {
		return new Page();
	}
	
}
