package com.youthministry.controller.impl;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.youthministry.domain.Page;
import com.youthministry.domain.Group;
import com.youthministry.controller.AbstractAdminController;
import com.youthministry.controller.validator.PageValidator;

@Controller
public class AdminPageController extends AbstractAdminController {

	@Override
	@RequestMapping(value={"/admin/deletepage/{id}"})
	public String handleDelete(@PathVariable String id) {
		return "admin";
	}
	
	@Override
	@RequestMapping(value={"/admin/updatepage/{id}"},method=RequestMethod.POST)
	public String handleUpdate(@PathVariable String id, @ModelAttribute(value="page") Object object, BindingResult errors, Model map) {
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("contentItems", PageContentService.getAllPageContent());
		map.addAttribute("images", PageContentService.getAllImageEntries());
		map.addAttribute("textEntries", PageContentService.getAllTextEntries());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
		map.addAttribute("pages", PageService.getPages());
		Page page = (Page) object;
		this.setValidator(new PageValidator());
		this.getValidator().validate(page, errors);
		page.setPageId(Long.parseLong(id));
		if(! errors.hasErrors()) {
			try {
				PageService.updatePage(page);
				return "redirect:/admin";
			} catch(ConstraintViolationException cve) {
				errors.rejectValue("pageName", "pageName.duplicate", "This page is already in use.");
				System.out.println(cve.getConstraintName());
			}
		}
		return "admin";
	}

	@Override
	@RequestMapping(value={"/admin/createpage"},method=RequestMethod.POST)
	public String handleCreate(@ModelAttribute(value="page") Object object, BindingResult errors, Model map) {
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("contentItems", PageContentService.getAllPageContent());
		map.addAttribute("images", PageContentService.getAllImageEntries());
		map.addAttribute("textEntries", PageContentService.getAllTextEntries());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
		map.addAttribute("pages", PageService.getPages());
		Page page = (Page) object;
		this.setValidator(new PageValidator());
		this.getValidator().validate(page, errors);
		if(! errors.hasErrors()) {
			try {
				//System.out.println()
				PageService.addPage(page);
				return "redirect:/admin";
			} catch(ConstraintViolationException cve) {
				errors.rejectValue("pageName", "pageName.duplicate", "This page is already in use.");
				System.out.println(cve.getConstraintName());
			}
		}
		return "admin";
	}

	
}
