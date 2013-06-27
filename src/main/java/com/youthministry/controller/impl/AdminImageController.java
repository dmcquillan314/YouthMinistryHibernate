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
import com.youthministry.domain.Image;

@Controller
public class AdminImageController extends AbstractAdminController {

	@Override
	@RequestMapping(value={"/admin/createimage"},method=RequestMethod.POST)
	public String handleCreate(@ModelAttribute(value="image") Object object, BindingResult errors,
			Model map) {
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("contentItems", PageContentService.getAllPageContent());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
		map.addAttribute("pages", PageService.getPages());
		map.addAttribute("images", ImageService.getAll());
		Image image = (Image) object;
		this.setValidator(new ImageValidator());
		this.getValidator().validate(image, errors);
		if(! errors.hasErrors()) {
			try {
				ImageService.create(image);
				return "redirect:/admin";
			} catch(ConstraintViolationException cve) {
				errors.rejectValue("imageName", "imageName.unknownError","An error occurred while processing your request.");
			}
		}
		return "admin";
	}
	
	@Override
	@RequestMapping(value={"/admin/updateimage/{id}"},method=RequestMethod.POST)
	public String handleUpdate(@PathVariable String id, @ModelAttribute(value="image") Object object, BindingResult errors,
			Model map) {
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("contentItems", PageContentService.getAllPageContent());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
		map.addAttribute("pages", PageService.getPages());
		map.addAttribute("images", ImageService.getAll());
		Image image = (Image) object;
		image.setImageId(Long.parseLong(id));
		this.setValidator(new ImageValidator());
		this.getValidator().validate(image, errors);
		if(! errors.hasErrors()) {
			try {
				ImageService.create(image);
				return "redirect:/admin";
			} catch(ConstraintViolationException cve) {
				errors.rejectValue("imageName", "imageName.unknownError","An error occurred while processing your request.");
			}
		}
		return "admin";
	}
	
	@Override
	@RequestMapping(value={"/admin/deleteimage"},method=RequestMethod.POST)
	public String handleDelete(@PathVariable String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
