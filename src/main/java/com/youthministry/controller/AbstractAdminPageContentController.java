package com.youthministry.controller;

import java.util.Collection;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.youthministry.controller.validator.PageContentValidator;
import com.youthministry.domain.EventLocation;
import com.youthministry.domain.Group;
import com.youthministry.domain.Image;
import com.youthministry.domain.TextEntry;
import com.youthministry.domain.User;
import com.youthministry.service.GroupService;
import com.youthministry.service.UserService;
import com.youthministry.service.PageContentService;
import com.youthministry.service.EventService;
import com.youthministry.service.RoleService;
import com.youthministry.service.PageService;

public abstract class AbstractAdminPageContentController extends AbstractAdminController {

	@Override
	public abstract String handleUpdate(String id, Object object, BindingResult errors,
			Model map);

	@Override
	public abstract String handleCreate(Object object, BindingResult errors, Model map);

	@Override
	public abstract String handleDelete(String id);
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
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
	}
		
}
