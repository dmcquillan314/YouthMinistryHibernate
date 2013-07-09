package com.youthministry.controller.impl;

import java.util.Collection;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.youthministry.controller.AbstractAdminController;
import com.youthministry.controller.validator.PageContentValidator;
import com.youthministry.domain.Image;
import com.youthministry.domain.Content;

@Controller
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
		map.addAttribute("renderers", RendererService.getAll());
		map.addAttribute("menus", MenuService.getAll());
		map.addAttribute("links", LinkService.getAll());
		Content pageContent = (Content) object;
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
		map.addAttribute("renderers", RendererService.getAll());
		map.addAttribute("menus", MenuService.getAll());
		map.addAttribute("links", LinkService.getAll());
		Content pageContent = (Content) object;
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
		binder.registerCustomEditor(Collection.class, "images", new CustomCollectionEditor(Collection.class) {
			protected Object convertElement(Object element) {
				if(element instanceof Image) {
					System.out.println("Converting from Image to Image: " + element);
					return element;
				}
				if(element instanceof String || element instanceof Long) {
					Image image = ImageService.read( Long.parseLong((String) element) );
					System.out.println("Looking up image for id " + element + ": " + image);
					return image;
				}
				System.out.println("Don't know what to do with: " + element);
				return null;
			}
		});
	}
		
}
