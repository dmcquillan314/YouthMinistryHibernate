package com.youthministry.controller.layout.impl;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.youthministry.controller.AbstractAdminController;
import com.youthministry.domain.Layout;

@Controller
public class AdminLayoutController extends AbstractAdminController {

	@Override
	@RequestMapping(value={"/admin/updatelayout/{id}"},method=RequestMethod.POST)
	public String handleUpdate(@PathVariable String id, @ModelAttribute(value="layout") Object object, BindingResult errors,
			Model map) {
		map.addAttribute("layouts", LayoutService.findAll());
		LayoutHelper layout = (LayoutHelper) object;
		//layout.setLayoutId(Long.parseLong(id));
		if(! errors.hasErrors()) {
			try {
				//LayoutService.update(layout);
				return "redirect:/admin/manage/layouts";
			} catch(ConstraintViolationException cve) {
			}
		}
		return "admin";
	}

	@Override
	@RequestMapping(value={"/admin/createlayout"},method=RequestMethod.POST)
	public String handleCreate(@ModelAttribute(value="layout") Object object, BindingResult errors, Model map) {
		map.addAttribute("layouts", LayoutService.findAll());
		LayoutHelper layout = (LayoutHelper) object;
		if(! errors.hasErrors()) {
			try {
				//LayoutService.create(layout);
				return "redirect:/admin/manage/layouts";
			} catch(ConstraintViolationException cve) {
			}
		}
		return "admin";
	}

	@Override
	@RequestMapping(value={"/admin/deletelayout"},method=RequestMethod.POST)
	public String handleDelete(String id) {
		return null;
	}

}
