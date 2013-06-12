package com.youthministry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import com.youthministry.service.GroupService;
import com.youthministry.service.UserService;
import com.youthministry.service.PageService;
import com.youthministry.service.PageContentService;
import com.youthministry.service.EventService;
import com.youthministry.service.RoleService;

public abstract class AbstractAdminController {

	@Autowired
	protected GroupService GroupService;
	@Autowired
	protected PageService PageService;
	@Autowired
	protected UserService UserService;
	@Autowired
	protected PageContentService PageContentService;
	@Autowired
	protected EventService EventService;
	@Autowired
	protected RoleService RoleService;
	
	protected Validator validator;

	public Validator getValidator() {
		return this.validator;
	}
	
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	public abstract String handleUpdate(String id, Object object, BindingResult errors, Model map);
	
	public abstract String handleCreate(Object object, BindingResult errors, Model map);
	
	public abstract String handleDelete(String id);

	
}
