package com.youthministry.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.youthministry.dao.GroupDao;
import com.youthministry.domain.Event;
import com.youthministry.domain.Group;

public class GroupDaoImpl implements GroupDao {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addGroup(Group group) {
		getSessionFactory().getCurrentSession().save(group);
	}

	@Override
	public void updateGroup(Group group) {
		getSessionFactory().getCurrentSession().merge(group);
	}

	@Override
	public void deleteGroup(Group group) {
		getSessionFactory().getCurrentSession().delete(group);
	}

	@Override
	public Group getGroupById(Long id) {
		List list = getSessionFactory().getCurrentSession().createQuery("from GROUP_DETAIL where groupId=?").setParameter(0, id).list();
		return (Group) list.get(0);
	}

	@Override
	public Group getGroupByName(String name) {
		List list = getSessionFactory().getCurrentSession().createQuery("from GROUP_DETAIL where groupName=?").setParameter(0, name).list();
		return (Group) list.get(0);
	}

	@Override
	public List<Group> getGroups() {
		List list = getSessionFactory().getCurrentSession().createQuery("from GROUP_DETAIL").list();
		return (List<Group>) list;
	}

}