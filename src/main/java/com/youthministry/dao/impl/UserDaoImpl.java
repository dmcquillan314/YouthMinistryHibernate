package com.youthministry.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.youthministry.dao.UserDao;
import com.youthministry.domain.User;

public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addUser(User user) {
		getSessionFactory().getCurrentSession().save(user);
	}

	@Override
	public void updateUser(User user) {
		getSessionFactory().getCurrentSession().merge(user);
	}

	@Override
	public void deleteUser(User user) {
		getSessionFactory().getCurrentSession().delete(user);
	}

	@Override
	public User getUserById(Long id) {
		List list = getSessionFactory().getCurrentSession().createQuery("from User where id=?")
															.setParameter(0, id).list();
		return (User)list.get(0);
	}

	@Override
	public User getUserByName(String name) {
		List list = getSessionFactory().getCurrentSession().createQuery("from User where username=?")
				.setParameter(0, name).list();
		return (User)list.get(0);
	}

	@Override
	public List<User> getUsers() {
		return getSessionFactory().getCurrentSession().createQuery("from User").list();
	}

	@Override
	public User getUserByIdWithGroups(Long id) {
		List list = getSessionFactory().getCurrentSession().createQuery("from User u").list();
		return (User)list.get(0);
		//return null;
	}

	@Override
	public User getUserByNameWithGroups(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsersWithGroups() {
		// TODO Auto-generated method stub
		return null;
	}

}