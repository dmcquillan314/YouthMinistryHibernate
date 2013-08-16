package com.youthministry.page.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.youthministry.domain.PageContent;
import com.youthministry.service.PageContentService;

@Controller
@SessionAttributes({"page"})
public class AdminPageController {
	
	@Autowired
	private PageContentService PageContentService;

	@RequestMapping(value="/admin/page/select-layout")
	public ModelAndView handleSelectLayout() {
		ModelAndView modelAndView = new ModelAndView();
		
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/page")
	public ModelAndView handleEnterPageAttributes() {
		ModelAndView modelAndView = new ModelAndView();
		
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/page/add-content")
	public ModelAndView handleAddContent() {
		ModelAndView modelAndView = new ModelAndView();
		
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/page/review")
	public ModelAndView handleReviewPage() {
		ModelAndView modelAndView = new ModelAndView();
		
		return modelAndView;
	}
		
	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(Collection.class, "contentItems", new CustomCollectionEditor(Collection.class) {
			protected Object convertElement(Object element) {
				if(element instanceof PageContent) {
					System.out.println("Converting from Page Content to String: " + element);
					return element;
				}
				if(element instanceof String || element instanceof Long) {
					PageContent pageContent = PageContentService.getPageContentById(Long.parseLong((String) element));
					System.out.println("Looking up Page Content for id " + element + ": " + pageContent);
					return pageContent;
				}
				System.out.println("Don't know what to do with: " + element);
				return null;
			}
		});
	}

}
