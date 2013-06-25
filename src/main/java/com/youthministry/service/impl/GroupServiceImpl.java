package com.youthministry.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.youthministry.dao.GroupDao;
import com.youthministry.domain.Group;
import com.youthministry.genericdao.GenericDao;
import com.youthministry.service.GroupService;

@Transactional(readOnly=true)
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupDao groupDao;
		
	@Transactional(readOnly=false)
	@Override
	public void addGroup(Group group) {
		groupDao.create(group);
	}

	@Transactional(readOnly=false)
	@Override
	public void updateGroup(Group group) {
		groupDao.update(group);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteGroup(Group group) {
		groupDao.delete(group);
	}

	@Transactional(readOnly=true)
	@Override
	public Group getGroupById(Long id) {
		return (Group) groupDao.read(id);
	}

	@Override
	public Group getGroupByName(String name) {
		return groupDao.findByName(name).get(0);
	}

	@Override
	public List<Group> getGroups() {
		return groupDao.findAll();
	}

}
