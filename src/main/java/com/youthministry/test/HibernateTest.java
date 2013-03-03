package com.youthministry.test;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.youthministry.domain.Group;
import com.youthministry.domain.Role;
import com.youthministry.domain.User;
import com.youthministry.domain.UserProfile;
import com.youthministry.service.UserService;

public class HibernateTest {

	public static void InitData() {
		ApplicationContext context = new ClassPathXmlApplicationContext("config-spring-hibernate.xml");
		UserService userService = (UserService) context.getBean("UserService");
		for(int j = 0; j < 10; j++) {
			UserProfile userProf = new UserProfile();
			userProf.setFirstName("first name" + j);
			userProf.setLastName("last name" + j);
			Role role = new Role();
			role.setRoleName("default");
			role.setRoleDesc("default role status");
			User user = new User("username"+j, "password" + j, userProf, role);
			for(int i = 0; i < 5; i++) {
				Group group = new Group();
				group.setGroupName("test group " + i + " " + j);
				group.setGroupDesc("test group description " + i + " " + j);
				user.getGroups().add(group);
			}
			
			userService.addUser(user);
		}	
		User u = userService.getUserById((long) 1);
		System.out.println(u.getUsername());
	}

	public static void main(String[] args) {
		InitData();
	}

}
