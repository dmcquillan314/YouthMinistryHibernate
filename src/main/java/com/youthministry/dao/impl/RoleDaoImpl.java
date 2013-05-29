package com.youthministry.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.youthministry.dao.RoleDao;
import com.youthministry.domain.Event;
import com.youthministry.domain.Group;
import com.youthministry.domain.Role;

public class RoleDaoImpl implements RoleDao {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addRole(Role role) {
		getSessionFactory().getCurrentSession().save(role);
	}

	@Override
	public void updateRole(Role role) {
		getSessionFactory().getCurrentSession().update(role);
	}

	@Override
	public void deleteRole(Role role) {
		getSessionFactory().getCurrentSession().delete(role);
	}

	@Override
	public Role getRoleById(Long id) {
		return (Role) getSessionFactory().getCurrentSession().createQuery("from Role where id = ?").setParameter(0, id).list().get(0);
	}

	@Override
	public Role getRoleByName(String name) {
		return (Role) getSessionFactory().getCurrentSession().createQuery("from Role where name = ?").setParameter(0, name).list().get(0);
	}

	@Override
	public List<Role> getRoles() {
		return (List<Role>) getSessionFactory().getCurrentSession().createQuery("from Role").list();
	}
	

}