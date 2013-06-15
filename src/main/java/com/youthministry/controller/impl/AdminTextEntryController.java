package com.youthministry.controller.impl;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.youthministry.controller.AbstractAdminPageContentController;
import com.youthministry.controller.validator.PageContentValidator;
import com.youthministry.domain.TextEntry;

@Controller
public class AdminTextEntryController extends AbstractAdminPageContentController {
	
	@Override
	@RequestMapping(value={"/admin/updatetextentry/{id}"},method=RequestMethod.POST)
	public String handleUpdate(@PathVariable String id, @ModelAttribute(value="textEntry") Object object, BindingResult errors, Model map) {
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("contentItems", PageContentService.getAllPageContent());
		map.addAttribute("images", PageContentService.getAllImageEntries());
		map.addAttribute("textEntries", PageContentService.getAllTextEntries());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
		map.addAttribute("pages", PageService.getPages());
		TextEntry textEntry = (TextEntry) object;
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
	
	@Override
	@RequestMapping(value={"/admin/createtextentry"},method=RequestMethod.POST)
	public String handleCreate(@ModelAttribute(value="textEntry") Object object, BindingResult errors, Model map) {
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("contentItems", PageContentService.getAllPageContent());
		map.addAttribute("images", PageContentService.getAllImageEntries());
		map.addAttribute("textEntries", PageContentService.getAllTextEntries());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
		map.addAttribute("pages", PageService.getPages());
		TextEntry textEntry = (TextEntry) object;
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

	@Override
	public String handleDelete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}