package com.youthministry.page.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.youthministry.domain.Layout;
import com.youthministry.domain.Page;
import com.youthministry.domain.PageContent;
import com.youthministry.domain.Row;
import com.youthministry.page.validator.PageValidator;
import com.youthministry.service.PageContentService;
import com.youthministry.service.PageService;
import com.youthministry.service.LayoutService;

@Controller
@SessionAttributes({"page"})
@RequestMapping(value={"/admin/manage/pages"})
public class AdminPageController {
	
	@Autowired
	private PageContentService PageContentService;
	@Autowired
	private LayoutService LayoutService;
	@Autowired
	private PageService PageService;
	
	protected static Validator validator;
	
	public enum SubmitType {
		SUBMIT,
		CANCEL
	};
	
	private static final String PARAM_FINISH = "_finish";
	private static final String PARAM_CANCEL = "_cancel";
	private static final String PARAM_TARGET = "_target";
	private static final String PARAM_PAGE = "_page";
	private static final String PARAM_SUBMIT = "submit";
	private static final String PARAM_LAYOUT = "layout";
	
	private static ArrayList<String> pages = new ArrayList<String>();

	static {
        pages.add("admin/pages/pages");
        pages.add("admin/pages/pages_choose_layout");
        pages.add("admin/pages/pages_attach_content");
        pages.add("admin/pages/pages_review");
	}
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView handleManagePage( 
				@ModelAttribute( "page" ) Page page, 
				HttpServletRequest request, ModelAndView modelAndView 
			) {
		
		List<Layout> layouts = LayoutService.findAll();
		
		if( layouts != null && layouts.size() > 0 ) {
			modelAndView.addObject("layouts", layouts);
		}
		
		modelAndView.setViewName(this.getPages().get( 0 ) );
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView handleMangePageSubmit( 
			@ModelAttribute( "page" ) Page page,
			@RequestParam( value=PARAM_CANCEL, required=false ) String cancel,
			@RequestParam( value=PARAM_PAGE, required=false ) String curPage,
			@RequestParam( value=PARAM_TARGET, required=false ) String target,
			@RequestParam( required=false, value=PARAM_SUBMIT) String submit,
			HttpServletRequest request,
			BindingResult errors,
			ModelAndView modelAndView
		) {
		this.setValidator(new PageValidator());

		SubmitType submitType = SubmitType.valueOf(submit.toUpperCase());
		
		modelAndView.addObject("curPage", curPage);
		
		List<Layout> layouts = LayoutService.findAll();
		
		if( layouts != null && layouts.size() > 0 ) {
			modelAndView.addObject("layouts", layouts);
		}

		if( submitType == SubmitType.SUBMIT) {
			switch( Integer.parseInt( curPage )) {
				case 0:
					handlePage1Form( request, modelAndView, page, errors );
					break;
				case 1:
					handlePage2Form( request, modelAndView, page, errors );
					break;
				case 2:
					handlePage3Form( request, modelAndView, page, errors );
					break;
				case 3:
					handlePage4Form( request, modelAndView, page, errors );
					break;
			}
			if( errors.hasErrors() ) {
				modelAndView.setViewName( pages.get( Integer.parseInt( curPage ) ) );
			} else {
				modelAndView.setViewName( pages.get( Integer.parseInt( target ) ) );
			}
		} else {
			modelAndView.setViewName( pages.get( Integer.parseInt( cancel ) ) );
		}
		return modelAndView;
	}
	
	public void handlePage1Form( HttpServletRequest request, ModelAndView modelAndView, Page page, BindingResult errors ) {
		this.getValidator().validatePage1Form(page, errors);
	}
	
	public void handlePage2Form( HttpServletRequest request, ModelAndView modelAndView, Page page, BindingResult errors ) {
		this.getValidator().validatePage2Form(page, errors);
		String layoutId = request.getParameter(PARAM_LAYOUT);
		if ( layoutId == null ) {
			errors.rejectValue("rows", "rows.required", "Layout is required");
		} else {
			Layout layout = this.LayoutService.read(Long.parseLong( layoutId.trim() ) );
			page.setRows(layout.getRows());
		}
	}
	
	public void handlePage3Form( HttpServletRequest request, ModelAndView modelAndView, Page page, BindingResult errors ) {
		this.getValidator().validatePage1Form(page, errors);
	}
	
	public void handlePage4Form( HttpServletRequest request, ModelAndView modelAndView, Page page, BindingResult errors ) {
		this.getValidator().validatePage1Form(page, errors);
	}
	
	@ModelAttribute("page")
	public Page getPage() {
		return new Page();
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

	/**
	 * @return the validator
	 */
	public PageValidator getValidator() {
		return (PageValidator) validator;
	}

	/**
	 * @param validator the validator to set
	 */
	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	/**
	 * @return the pages
	 */
	public ArrayList<String> getPages() {
		return pages;
	}

	/**
	 * @param pages the pages to set
	 */
	public void setPages(ArrayList<String> pages) {
		this.pages = pages;
	}

}
