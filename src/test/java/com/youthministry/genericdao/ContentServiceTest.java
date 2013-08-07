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
import com.youthministry.domain.User;
import com.youthministry.domain.UserProfile;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:META-INF/spring/applicationContext*.xml"}) 
@TransactionConfiguration
@Transactional
public class ContentServiceTest {
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
	protected UserDao userDao;

    final Logger logger = LoggerFactory.getLogger(ContentServiceTest.class);
    
	public Long testCreatePageContent() {
		PageContent pageContent = new PageContent();
		pageContent.setPageContentName("test case page name");
		pageContent.setContentTitle("test case content title");
		pageContent.setContentBody("test case content body");
		
		Image image = new Image();
		Image image2 = new Image();
		image.setPathToImage("test case path to image");
		image.setAltText("test case alt text");
		image.setTitleText("test case alt text");
		image2.setPathToImage("test case 2 path to image");
		image2.setAltText("test case 2 alt text");
		image2.setTitleText("test case 2 alt text");
		ArrayList<Image> images = new ArrayList<Image>();
		images.add(image);
		images.add(image2);
		pageContent.setImages(images);
		
		PageContentService.addPageContent(pageContent);
		
		return pageContent.getPageContentId();
	}
	
	@Test
	public void testReadPageContent() {
		
		PageContent pageContent = PageContentService.getPageContentById(testCreatePageContent());
	
	}
	
	@Test
	public void testUpdatePageContent() {
		
		PageContent pageContent = PageContentService.getPageContentById(testCreatePageContent());
		
		pageContent.setPageContentName("test case page name updated");
		
		PageContentService.updatePageContent(pageContent);
	}
	
	@Test
	public void testDeletePageContent() {
		PageContent pageContent = PageContentService.getPageContentById(testCreatePageContent());
		
		PageContentService.deletePageContent(pageContent);
		
	}

}
