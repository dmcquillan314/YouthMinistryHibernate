package com.youthministry.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.youthministry.domain.Group;
import com.youthministry.genericdao.GenericDao;
import com.youthministry.service.GroupService;

@Transactional(readOnly=true)
public class GroupServiceImpl implements GroupService {

	private GenericDao genericDao;
	
	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}
	
	public GenericDao getGenericDao() {
		return this.genericDao;
	}
	
	@Transactional(readOnly=false)
	@Override
	public void addGroup(Group group) {
		getGenericDao().create(group);
	}

	@Transactional(readOnly=false)
	@Override
	public void updateGroup(Group group) {
		getGenericDao().update(group);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteGroup(Group group) {
		getGenericDao().delete(group);
	}

	@Transactional(readOnly=true)
	@Override
	public Group getGroupById(Long id) {
		return (Group) getGenericDao().read(id);
	}

	@Override
	public Group getGroupByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Group> getGroups() {
		// TODO Auto-generated method stub
		return null;
	}

}
