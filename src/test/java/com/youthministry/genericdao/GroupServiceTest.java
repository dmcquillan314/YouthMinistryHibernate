package com.youthministry.genericdao;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.youthministry.service.GroupService;
import com.youthministry.domain.Group;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:META-INF/spring/applicationContext*.xml"}) 
@TransactionConfiguration
@Transactional
public class GroupServiceTest {
	@Autowired
	protected GroupService GroupService;

    final Logger logger = LoggerFactory.getLogger(GroupServiceTest.class);
    
    public Long testCreateGroup() {
    	Group group = new Group();
		group.setGroupName("test case group name");
		group.setGroupDesc("test case group desc");
		GroupService.addGroup(group);
		return group.getGroupId();
    }
    
    @Test
    public void testReadGroup() {
    	Group group = GroupService.getGroupById(testCreateGroup());
    	assertThat(null, is(not(group)));
    }
    
    @Test
    public void testUpdateGroup() {
    	Group group = GroupService.getGroupById(testCreateGroup());
    	String groupName = group.getGroupName();
    	logger.info(groupName);
    	group.setGroupName("test case group name updated");
    	logger.info(group.getGroupName());
    	GroupService.updateGroup(group);
    	assertThat(group.getGroupName(), is(not(groupName)));
    }
    
    @Test
    public void testDeleteGroup() {
    	Long id = testCreateGroup();
    	Group group = GroupService.getGroupById(testCreateGroup());
    	GroupService.deleteGroup(group);
    	logger.info(GroupService.getGroupById(id).getGroupName());
    	//assertThat(null, is(GroupService.getGroupById(id)));
    }
}
