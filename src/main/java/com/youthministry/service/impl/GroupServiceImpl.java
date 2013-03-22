package com.youthministry.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.youthministry.dao.GroupDao;
import com.youthministry.domain.Group;
import com.youthministry.service.GroupService;

@Transactional(readOnly=true)
public class GroupServiceImpl implements GroupService {

	private GroupDao groupDao;
	
	@Transactional(readOnly=false)
	@Override
	public void addGroup(Group group) {
		getGroupDao().addGroup(group);
	}

	@Transactional(readOnly=false)
	@Override
	public void updateGroup(Group group) {
		getGroupDao().updateGroup(group);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteGroup(Group group) {
		getGroupDao().deleteGroup(group);
	}

	@Transactional(readOnly=true)
	@Override
	public Group getGroupById(int id) {
		return getGroupDao().getGroupById(id);
	}

	@Transactional(readOnly=true)
	@Override
	public Group getGroupByName(String name) {
		// TODO Auto-generated method stub
		return getGroupDao().getGroupByName(name);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Group> getGroups() {
		return getGroupDao().getGroups();
	}

	public GroupDao getGroupDao() {
		return groupDao;
	}

	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}

}
