package com.youthministry.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.youthministry.controller.forms.GroupForm;
import com.youthministry.domain.Group;
import com.youthministry.service.GroupService;

@Controller
public class AdminController {

	@Autowired
	private GroupService GroupService;

	@RequestMapping(value={"/admin"})
	public String admin() {
		return "admin";
	}
	
	@RequestMapping(value={"/admin/groups"})
	public GroupForm admin(WebRequest request) {
		return new GroupForm();
	}
	
	@RequestMapping(value={"/admin/groups"},method=RequestMethod.POST)
	public String createGroup(@Valid GroupForm form, BindingResult formBinding, WebRequest webRequest) {
		if(formBinding.hasErrors()) {
			return null;
		}
		createGroupHelper(form, formBinding);	
		return "redirect:/admin/groups";
		//Group group = createGroup()
	}
	
	private void createGroupHelper(GroupForm form, BindingResult formBinding) {
		Group group = new Group();
		group.setGroupName(form.getGroupName());
		group.setGroupDesc(form.getGroupDesc());
		GroupService.addGroup(group);
	}
}
