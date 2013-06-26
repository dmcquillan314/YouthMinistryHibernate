package com.youthministry.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.youthministry.service.EventService;
import com.youthministry.service.PageContentService;
import com.youthministry.service.GroupService;

@Controller
public class UserController {
	
	@Autowired
	private PageContentService PageContentService;
	@Autowired
	private EventService EventService;
	@Autowired
	private GroupService GroupService;
	
	@RequestMapping(value={"/group","/home"})
	public ModelAndView groupView(HttpServletRequest request) {
		System.out.println(request.getServletPath());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("groupName", "no group specified");
		return new ModelAndView("viewGroup", "model", model);
	}
	
	@RequestMapping(value={"/group/{groupName}"})
	public ModelAndView groupView(HttpServletRequest request, @PathVariable String groupName) {
		System.out.println(request.getServletPath());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("groupName", groupName);
		model.put("groups", GroupService.getGroups());
		model.put("events", EventService.getEvents());
		return new ModelAndView("viewGroup", "model", model);
	}
	
}