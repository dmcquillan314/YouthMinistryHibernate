package com.youthministry.genericdao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.youthministry.service.EventService;
import com.youthministry.service.GroupService;
import com.youthministry.service.PageContentService;
import com.youthministry.service.PageService;
import com.youthministry.service.RoleService;
import com.youthministry.service.UserService;

import com.youthministry.dao.UserDao;
import com.youthministry.domain.Event;
import com.youthministry.domain.Group;
import com.youthministry.domain.Image;
import com.youthministry.domain.Location;
import com.youthministry.domain.Page;
import com.youthministry.domain.PageContent;
import com.youthministry.domain.Role;
import com.youthministry.domain.TextEntry;
import com.youthministry.domain.User;
import com.youthministry.domain.UserProfile;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "root-context.xml"}) 
@TransactionConfiguration
@Transactional
public class PageServiceTest {
	@Autowired
	protected PageService PageService;

    final Logger logger = LoggerFactory.getLogger(PageServiceTest.class);
    
	public Long testCreatePage() {
		Page page = new Page();
		page.setPageName("test page name");
		page.setPageUrl("test page url");
		PageService.addPage(page);
		Long id = page.getPageId();
		
		return id;
	}
	
	@Test
	public void testReadPage() {
		Long id = testCreatePage();
		Page page = PageService.getPageById(id);
	}
	
	@Test
	public void testUpdatePage() {
		Long id = testCreatePage();
		Page page = PageService.getPageById(id);
		page.setPageName("test page name updated");
		
		PageService.updatePage(page);
	}
	
	@Test
	public void testDeletePage() {
		Long id = testCreatePage();
		Page page = PageService.getPageById(id);
		PageService.deletePage(page);
	}

}
