package com.youthministry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.youthministry.controller.layout.impl.LayoutHelper;
import com.youthministry.controller.upload.FileUpload;
import com.youthministry.domain.Event;
import com.youthministry.domain.EventLocation;
import com.youthministry.domain.Group;
import com.youthministry.domain.Image;
import com.youthministry.domain.Layout;
import com.youthministry.domain.Link;
import com.youthministry.domain.Menu;
import com.youthministry.domain.Page;
import com.youthministry.domain.PageContent;
import com.youthministry.domain.Renderer;
import com.youthministry.domain.Role;
import com.youthministry.domain.User;
import com.youthministry.service.GroupService;
import com.youthministry.service.ImageService;
import com.youthministry.service.UserService;
import com.youthministry.service.PageService;
import com.youthministry.service.PageContentService;
import com.youthministry.service.EventService;
import com.youthministry.service.RoleService;
import com.youthministry.service.RendererService;
import com.youthministry.service.MenuService;
import com.youthministry.service.LinkService;
import com.youthministry.service.LayoutService;

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
	@Autowired
	protected ImageService ImageService;
	@Autowired
	protected RendererService RendererService;
	@Autowired
	protected MenuService MenuService;
	@Autowired
	protected LinkService LinkService;
	@Autowired
	protected LayoutService LayoutService;
	
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

	@ModelAttribute(value="user")
	public User getUser() {
		return new User();
	}
	@ModelAttribute(value="group")
	public Group getGroup() {
		return new Group();
	}
	@ModelAttribute(value="image")
	public Image getImage() {
		return new Image();
	}
	@ModelAttribute(value="link")
	public Link getLink() {
		return new Link();
	}
	@ModelAttribute(value="menu")
	public Menu getMenu() {
		return new Menu();
	}
	@ModelAttribute(value="renderer")
	public Renderer getRenderer() {
		return new Renderer();
	}
	@ModelAttribute(value="pageContent")
	public PageContent getPageContent() {
		return new PageContent();
	}
	@ModelAttribute(value="event")
	public Event getEvent() {
		return new Event();
	}
	@ModelAttribute(value="eventLocation")
	public EventLocation getEventLocation() {
		return new EventLocation();
	}
	@ModelAttribute(value="role")
	public Role getRole() {
		return new Role();
	}
	@ModelAttribute(value="page")
	public Page getPage() {
		return new Page();
	}
	@ModelAttribute(value="document")
	public FileUpload getFileUpload() {
		return new FileUpload();
	}
	@ModelAttribute(value="layout")
	public Layout getLayout() {
		return new Layout();
	}
	
}
