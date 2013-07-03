package com.youthministry.genericdao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.youthministry.service.UserService;

import com.youthministry.domain.User;
import com.youthministry.domain.UserProfile;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "root-context.xml"}) 
@TransactionConfiguration
@Transactional
public class UserServiceTest {
	@Autowired
	protected UserService UserService;
	
    final Logger logger = LoggerFactory.getLogger(UserService.class);
    
	public Long testCreateUser() {
		User user = new User();
		user.setUsername("test");
		user.setPassword("test");
		UserProfile userProfile = new UserProfile();
		user.setUserProfile(userProfile);
		user.getUserProfile().setFirstName("firstName");
		user.getUserProfile().setLastName("lastName");
		
		UserService.addUser(user);
		
		return user.getUserId();
	}
	
	@Test
	public void testReadUser() {
		User user = UserService.getByUserId(testCreateUser());
	}
	
	@Test
	public void testUpdateUser() {
		User user = UserService.getByUserId(testCreateUser());
		user.setUsername("test updated");
		UserService.updateUser(user);
	}
	
	@Test
	public void testDeleteUser() {
		User user = UserService.getByUserId(testCreateUser());
    	UserService.deleteUser(user);
	}

}
