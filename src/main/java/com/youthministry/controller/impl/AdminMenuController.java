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
import com.youthministry.controller.validator.ImageValidator;
import com.youthministry.controller.validator.MenuValidator;
import com.youthministry.domain.Image;
import com.youthministry.domain.Menu;

@Controller
public class AdminMenuController extends AbstractAdminController {

	@Override
	@RequestMapping(value={"/admin/updatemenu/{id}"},method=RequestMethod.POST)
	public String handleUpdate(@PathVariable String id, @ModelAttribute(value="menu") Object object, BindingResult errors,
			Model map) {
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("contentItems", PageContentService.getAllPageContent());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
		map.addAttribute("pages", PageService.getPages());
		map.addAttribute("images", ImageService.getAll());
		map.addAttribute("renderers", RendererService.getAll());
		map.addAttribute("menus", MenuService.getAll());
		map.addAttribute("links", LinkService.getAll());
		Menu menu = (Menu) object;
		menu.setMenuId(Long.parseLong(id));
		this.setValidator(new MenuValidator());
		this.getValidator().validate(menu, errors);
		if(! errors.hasErrors()) {
			try {
				MenuService.create(menu);
				return "redirect:/admin";
			} catch(ConstraintViolationException cve) {
				errors.rejectValue("imageName", "imageName.unknownError","An error occurred while processing your request.");
			}
		}
		return "admin";
	}

	@Override
	@RequestMapping(value={"/admin/createmenu"},method=RequestMethod.POST)
	public String handleCreate(@ModelAttribute(value="menu") Object object, BindingResult errors, Model map) {
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("contentItems", PageContentService.getAllPageContent());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
		map.addAttribute("pages", PageService.getPages());
		map.addAttribute("images", ImageService.getAll());
		map.addAttribute("renderers", RendererService.getAll());
		map.addAttribute("menus", MenuService.getAll());
		map.addAttribute("links", LinkService.getAll());
		Menu menu = (Menu) object;
		this.setValidator(new MenuValidator());
		this.getValidator().validate(menu, errors);
		if(! errors.hasErrors()) {
			try {
				MenuService.create(menu);
				return "redirect:/admin";
			} catch(ConstraintViolationException cve) {
				errors.rejectValue("imageName", "imageName.unknownError","An error occurred while processing your request.");
			}
		}
		return "admin";
	}

	@Override
	@RequestMapping(value={"/admin/deletemenu"},method=RequestMethod.POST)
	public String handleDelete(String id) {
		return null;
	}

}
