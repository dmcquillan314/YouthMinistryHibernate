package com.youthministry.test;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.youthministry.domain.Group;
import com.youthministry.domain.User;
import com.youthministry.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config-spring-hibernate.xml")
public class HibernateConfigTest {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private UserService UserService;
	
	@Test
	public void retrieveAccount() {
		Long zero = (long) 1;
		User user = UserService.getUserById(zero);
	}
	
	@Test @Transactional
	public void updateAccount() {
		UserService userService = UserService;
		User u = userService.getUserById((long) 1);
		u.setUsername("changed by junit test");
		userService.updateUser(u);
	}
	
	@Test
	public void retrieveGroups() {
		User u = UserService.getUserByIdWithGroups((long) 1);
		List<Group> groups = (List<Group>) u.getGroups();
		for(Group g : groups) {
			System.out.println(g.getGroupName());
		}
	}
	
}
