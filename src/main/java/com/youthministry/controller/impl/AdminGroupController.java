package com.youthministry.controller.impl;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.youthministry.controller.AbstractAdminController;
import com.youthministry.controller.validator.GroupValidator;
import com.youthministry.domain.Group;

@Controller
public class AdminGroupController extends AbstractAdminController {
	
	@Override
	@RequestMapping(value={"/admin/creategroup"},method=RequestMethod.POST)
	public String handleCreate(@ModelAttribute(value="group") Object object, BindingResult errors, Model map) {
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("contentItems", PageContentService.getAllPageContent());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
		map.addAttribute("pages", PageService.getPages());
		Group group = (Group) object;
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
	
	@Override
	@RequestMapping(value={"/admin/updategroup/{id}"},method=RequestMethod.POST)
	public String handleUpdate(@PathVariable String id, @ModelAttribute(value="group") Object object, BindingResult errors, Model map) {
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("contentItems", PageContentService.getAllPageContent());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
		map.addAttribute("pages", PageService.getPages());
		Group group = (Group) object;
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
	
	@Override
	public String handleDelete(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
