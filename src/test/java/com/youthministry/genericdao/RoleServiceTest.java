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
import com.youthministry.service.ContentService;
import com.youthministry.service.PageService;
import com.youthministry.service.RoleService;
import com.youthministry.service.UserService;

import com.youthministry.dao.UserDao;
import com.youthministry.domain.Event;
import com.youthministry.domain.Group;
import com.youthministry.domain.Image;
import com.youthministry.domain.Location;
import com.youthministry.domain.Page;
import com.youthministry.domain.Content;
import com.youthministry.domain.Role;
import com.youthministry.domain.User;
import com.youthministry.domain.UserProfile;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "root-context.xml"}) 
@TransactionConfiguration
@Transactional
public class RoleServiceTest {
	@Autowired
	protected RoleService RoleService;
	
    final Logger logger = LoggerFactory.getLogger(RoleServiceTest.class);
    
    public Long testCreateRole() {
    	Role role = new Role();
    	role.setName("ROLE_TEST_CASE");
    	RoleService.addRole(role);
    	return role.getId();
    }
    
    @Test
    public void testReadRole() {
    	Role role = RoleService.getRoleById(testCreateRole());
    }
    
    @Test
    public void testUpdateRole() {
    	Role role = RoleService.getRoleById(testCreateRole());
    	role.setName("UPDATED_ROLE");
    	RoleService.updateRole(role);
    }
    
    @Test
    public void testDeleteRole() {
    	Role role = RoleService.getRoleById(testCreateRole());
    	RoleService.deleteRole(role);
    }
   
}
