package com.youthministry.controller.impl;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
import com.youthministry.domain.Group;
import com.youthministry.domain.User;
import com.youthministry.domain.Role;

@Controller
public class AdminUserController extends AbstractAdminController {
		
	@Override
	@RequestMapping(value={"/admin/updateuser/{id}"},method=RequestMethod.POST)
	public String handleUpdate(@PathVariable String id, @ModelAttribute(value="user") Object object, BindingResult errors,
			Model map) { 
		map.addAttribute("users", UserService.getUsers());
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("contentItems", PageContentService.getAllPageContent());
		map.addAttribute("events", EventService.getEvents());
		map.addAttribute("roles", RoleService.getRoles());
		map.addAttribute("pages", PageService.getPages());
		map.addAttribute("images", ImageService.getAll());
		User user = (User) object;
		user.setUserId(Long.parseLong(id));
		if(!errors.hasErrors()) {
			try {
				UserService.updateUser(user);
				return "redirect:/admin";
			} catch(ConstraintViolationException cve) {
				System.out.println(cve.getConstraintName());
			}
		}
		return "admin";
	}

	@Override
	public String handleCreate(Object object, BindingResult errors, Model map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String handleDelete(String id) {
		// TODO Auto-generated method stub
		return null;
	}
		
	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyyMMddHHmmss"), true);
		binder.registerCustomEditor(Date.class, editor);
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
		binder.registerCustomEditor(Collection.class, "roles", new CustomCollectionEditor(Collection.class) {
			protected Object convertElement(Object element) {
				if(element instanceof Role) {
					System.out.println("Converting from Role to Role: " + element);
					return element;
				}
				if(element instanceof String || element instanceof Long) {
					Role role = RoleService.getRoleById(Long.parseLong((String) element));
					System.out.println("Looking up role for id " + element + ": " + role);
					return role;
				}
				System.out.println("Don't know what to do with: " + element);
				return null;
			}
		});
	}		
}
