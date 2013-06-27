package com.youthministry.controller.impl;

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

import com.youthministry.controller.AbstractAdminController;
import com.youthministry.controller.validator.GroupValidator;
import com.youthministry.controller.validator.PageContentValidator;
import com.youthministry.domain.Event;
import com.youthministry.domain.EventLocation;
import com.youthministry.domain.Group;
import com.youthministry.domain.Image;
import com.youthministry.domain.Page;
import com.youthministry.domain.PageContent;
import com.youthministry.domain.Role;
import com.youthministry.domain.TextEntry;
import com.youthministry.domain.User;
import com.youthministry.service.GroupService;
import com.youthministry.service.UserService;
import com.youthministry.service.PageContentService;
import com.youthministry.service.EventService;
import com.youthministry.service.RoleService;
import com.youthministry.service.PageService;

public class AdminPageContentController extends AbstractAdminController {

	@Override
	@RequestMapping(value={"/admin/updatepagecontent/{id}"}, method=RequestMethod.POST)
	public String handleUpdate(@PathVariable String id, @ModelAttribute(value="pageContent") Object object, BindingResult errors, Model map) {
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("contentItems", PageContentService.getAllPageContent());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
		map.addAttribute("pages", PageService.getPages());
		map.addAttribute("images", ImageService.getAll());
		PageContent pageContent = (PageContent) object;
		pageContent.setPageContentId(Long.parseLong(id));
		this.setValidator(new PageContentValidator());
		this.getValidator().validate(pageContent, errors);
		if(! errors.hasErrors()) {
			try {
				PageContentService.updatePageContent(pageContent);
				return "redirect:/admin";
			} catch(ConstraintViolationException cve) {
				errors.rejectValue("pageName", "pageName.duplicate", "This page name is already in use.");
				System.out.println(cve.getConstraintName());
			}
		}
		return "admin";
	}
	
	@Override
	@RequestMapping(value={"/admin/createpagecontent"}, method=RequestMethod.POST)
	public String handleCreate(@ModelAttribute(value="pageContent") Object object, BindingResult errors, Model map) {
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("contentItems", PageContentService.getAllPageContent());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
		map.addAttribute("pages", PageService.getPages());
		PageContent pageContent = (PageContent) object;
		this.setValidator(new PageContentValidator());
		this.getValidator().validate(pageContent, errors);
		if(! errors.hasErrors()) {
			try {
				PageContentService.addPageContent(pageContent);
				return "redirect:/admin";
			} catch(ConstraintViolationException cve) {
				errors.rejectValue("pageName", "pageName.duplicate", "This page name is already in use.");
				System.out.println(cve.getConstraintName());
			}
		}
		return "admin";
	}
	
	@Override
	public String handleDelete(String id) {
		return "admin";
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
	@ModelAttribute(value="textEntry")
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
