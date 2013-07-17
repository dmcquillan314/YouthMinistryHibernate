package com.youthministry.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.youthministry.service.EventService;
import com.youthministry.service.GroupService;
import com.youthministry.service.PageService;

@Controller
public class UserController {
	
	@Autowired
	private PageService PageService;
	@Autowired
	private EventService EventService;
	@Autowired
	private GroupService GroupService;
	
	@RequestMapping(value={"/home"})
	public ModelAndView groupView(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("view", "model", model);
	}
	
	@RequestMapping(value={"/{pageUrl}"})
	public ModelAndView groupView(HttpServletRequest request, @PathVariable String pageUrl) {
		System.out.println(request.getServletPath());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("events", EventService.getEvents());
		if(pageUrl != null && !"".equals(pageUrl)) {
			model.put("page", PageService.findByUrl("/" + pageUrl));
		} else {
			model.put("page", pageUrl);
		}
		return new ModelAndView("view", "model", model);
	}
	
}