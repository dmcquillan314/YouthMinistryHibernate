package com.youthministry.genericdao;

import static org.junit.Assert.*;

import java.util.ArrayList;

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

import com.youthministry.domain.Event;
import com.youthministry.domain.EventLocation;
import com.youthministry.domain.Group;
import com.youthministry.domain.Image;
import com.youthministry.domain.Page;
import com.youthministry.domain.Role;
import com.youthministry.domain.TextEntry;
import com.youthministry.domain.User;
import com.youthministry.domain.UserProfile;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "root-context.xml"}) 
@TransactionConfiguration
@Transactional
public class GenericDaoTest {
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

    final Logger logger = LoggerFactory.getLogger(GenericDaoTest.class);
    
    public Long createGroup(Group group) {
		group.setGroupName("test case group name");
		group.setGroupDesc("test case group desc");
		GroupService.addGroup(group);
		return group.getGroupId();
    }
    public Long createRole(Role role) {
    	role.setName("ROLE_TEST_CASE");
    	RoleService.addRole(role);
    	return role.getId();
    }
    public void updateGroup(Long id) {
    	Group group = GroupService.getGroupById(id);
    	logger.info(group.getGroupName());
    	group.setGroupName("test case group name updated");
    	GroupService.updateGroup(group);
    	logger.info(group.getGroupName());
    }
    public void updateRole(Long id) {
    	Role role = RoleService.getRoleById(id);
    	logger.info(role.getName());
    	role.setName("UPDATED_ROLE");
    	logger.info(role.getName());
    }
    
    public void testTextEntry() {
    	TextEntry textEntry = new TextEntry();
    	textEntry.setPageContentName("test case page content name");
    	textEntry.setContentTitle("test case title");
    	textEntry.setContentBody("test case body");
    	textEntry.setLocation("test case location");
    	
    	Group group = new Group();
    	Group group2 = new Group();
    	group.setGroupName("test case group 1");
    	group2.setGroupName("test case group name 2");
    	
    	ArrayList<Group> groups = new ArrayList<Group>();
    	groups.add(group);
    	groups.add(group2);
    	
    	textEntry.setGroups(groups);
    	
    	PageContentService.addPageContent(textEntry);
    	logger.info(textEntry.toString());

    	logger.info(textEntry.getPageContentId().toString());

    	Long id = textEntry.getPageContentId();
    	
    	textEntry = null;

    	textEntry = (TextEntry) PageContentService.getPageContentById(id);
    	
    	logger.info(textEntry.getPageContentId().toString());
    	textEntry.setContentBody("updated content body");
    	
    	PageContentService.updatePageContent(textEntry);
    	logger.info(textEntry.getContentBody());

    	PageContentService.deletePageContent(textEntry);
    }
    
	//@Test
	public void testGroupService() {
		Group group = new Group();
		Long id = createGroup(group);
		updateGroup(id);
		GroupService.deleteGroup(group);
	}

	//@Test
	public void testPageService() {
		Page page = new Page();
		page.setPageName("test page name");
		page.setPageUrl("test page url");
		logger.info(page.getPageName());
		PageService.addPage(page);
		Long id = page.getPageId();
		
		page = PageService.getPageById(id);
		page.setPageName("test page name updated");
		logger.info(page.getPageName());
		
		PageService.updatePage(page);
		
		logger.info(page.getPageName());
		
		PageService.deletePage(page);

	}

	//@Test
	public void testUserService() {
		User user = new User();
		user.setUsername("test");
		user.setPassword("test");
		UserProfile userProfile = new UserProfile();
		user.setUserProfile(userProfile);
		user.getUserProfile().setFirstName("firstName");
		user.getUserProfile().setLastName("lastName");
		
		UserService.addUser(user);
		
		Long id = user.getUserId();
    	logger.info(user.getUsername());
    	logger.info(user.getPassword());
    	logger.info(user.getUserProfile().getFirstName());
    	logger.info(user.getUserProfile().getLastName());
		
		user = UserService.getUserById(id);
		
		user.setUsername("test updated");
		user.setPassword("test updated");
		user.getUserProfile().setFirstName("firstName updated");
		user.getUserProfile().setFirstName("lastName updated");
		
		UserService.updateUser(user);
    	logger.info(user.getUsername());
    	logger.info(user.getPassword());
    	logger.info(user.getUserProfile().getFirstName());
    	logger.info(user.getUserProfile().getLastName());

    	UserService.deleteUser(user);
	}

	@Test
	public void testPageContentService() {
	}

	public void testEventService() {
	}

	//@Test
	public void testRoleService() {
		Role role = new Role();
		Long id = createRole(role);
		updateRole(id);
		RoleService.deleteRole(role);
	}

}
