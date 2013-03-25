package com.youthministry.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.youthministry.controller.forms.GroupForm;
import com.youthministry.controller.validator.GroupValidator;
import com.youthministry.domain.Group;
import com.youthministry.service.GroupService;
import com.youthministry.service.UserService;

@Controller
public class AdminController {

	@Autowired
	private GroupService GroupService;
	@Autowired
	private UserService UserService;
	
	private Validator validator;

	@RequestMapping(value={"/admin"},method=RequestMethod.GET)
	public String admin(Model map) {
		map.addAttribute("groups", GroupService.getGroups());
		map.addAttribute("users", UserService.getUsers());
		return "admin";
	}
		
	@RequestMapping(value={"/admin"},method=RequestMethod.POST)
	public String handleCreateGroup(@ModelAttribute(value="group") Group group, BindingResult errors, ModelMap map) {
		this.setValidator(new GroupValidator());
		this.getValidator().validate(group, errors);
		if(! errors.hasErrors()) {
			GroupService.addGroup(group);
		}
		return "admin";
	}
	
	@ModelAttribute(value="group")
	public Group getGroup() {
		return new Group();
	}
	private Validator getValidator() {
		return validator;
	}

	private void setValidator(Validator validator) {
		this.validator = validator;
	}
	
}
