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
import com.youthministry.domain.PageContent;
import com.youthministry.domain.Image;
import com.youthministry.domain.TextEntry;

import com.youthministry.service.PageContentService;

public class HibernateTest {

	public static void InitData() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-hibernate.xml");
		PageContentService pageContentService = (PageContentService) context.getBean("PageContentService");
		
		PageContent pageContent = new PageContent();
		TextEntry textEntry = new TextEntry();
		Image image = new Image();
		
		textEntry.setPageContentName("test page content");
		textEntry.setLocation("test location");
		textEntry.setContentTitle("Title text");
		textEntry.setContentBody("content body");
		
		image.setPageContentName("test image content");
		image.setLocation("test location 2");
		image.setPathToImage("http://blah.com/image.gif");
		image.setAltText("image alt text");
		image.setTitleText("image title text");
		try {
			pageContentService.addPageContent(textEntry);
		} catch(Exception e) {
			
		}
		/*for(int j = 0; j < 10; j++) {
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
		System.out.println(u.getUsername());*/
	}

	public static void main(String[] args) {
		InitData();
	}

}
