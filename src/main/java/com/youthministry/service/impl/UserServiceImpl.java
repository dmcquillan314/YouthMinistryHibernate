package com.youthministry.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.youthministry.dao.UserDao;
import com.youthministry.domain.User;
import com.youthministry.service.UserService;

@Transactional(readOnly=true)
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	@Transactional(readOnly=false)
	@Override
	public void addUser(User user) {
		getUserDao().addUser(user);
	}

	@Transactional(readOnly=false)
	@Override
	public void updateUser(User user) {
		getUserDao().updateUser(user);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteUser(User user) {
		getUserDao().deleteUser(user);
	}

	@Transactional(readOnly=true)
	@Override
	public User getUserById(Long id) {
		return getUserDao().getUserById(id);
	}

	@Transactional(readOnly=true)
	@Override
	public User getUserByIdWithGroups(Long id) {
		return getUserDao().getUserByIdWithGroups(id);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<User> getUsers() {
		return getUserDao().getUsers();
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
