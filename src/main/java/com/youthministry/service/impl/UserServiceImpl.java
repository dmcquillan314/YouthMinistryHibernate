package com.youthministry.service.impl;

import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import com.youthministry.dao.UserDao;
import com.youthministry.domain.User;
import com.youthministry.domain.Group;
import com.youthministry.domain.Role;
import com.youthministry.service.UserService;

@Transactional(readOnly=true)
public class UserServiceImpl implements UserService {

	private UserDao userDao;
		
	@Transactional(readOnly=false)
	@Override
	public void addUser(User user) {
		getUserDao().create(user);
	}

	@Transactional(readOnly=false)
	@Override
	public void updateUser(User user) {
		User uTemp = (User) getUserDao().read(user.getUserId());
		if(user.getPassword() != null && !"".equals(user.getPassword())) {
			uTemp.setPassword(user.getPassword());
		}
		if(user.getGroups() != null && user.getGroups().size() > 0) {
			LinkedHashSet<Group> uGroups = (LinkedHashSet<Group>) user.getGroups();
			uTemp.setGroups(uGroups);
		}
		if(user.getRoles() != null && user.getRoles().size() > 0) {
			LinkedHashSet<Role> uRoles = (LinkedHashSet<Role>) user.getRoles();
			uTemp.setRoles(uRoles);
		}
		if(user.getUserProfile() != null) {
			if(user.getUserProfile().getFirstName() != uTemp.getUserProfile().getFirstName()) {
				uTemp.getUserProfile().setFirstName(user.getUserProfile().getFirstName());
			}
			if(user.getUserProfile().getLastName() != uTemp.getUserProfile().getLastName()) {		
				uTemp.getUserProfile().setLastName(user.getUserProfile().getLastName());
			}			
		}
		getUserDao().update(uTemp);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteUser(User user) {
		getUserDao().delete(user);
	}

	@Transactional(readOnly=true)
	@Override
	public User getByUserId(Long id) {
		return getUserDao().read(id);
	}

	@Transactional(readOnly=true)
	@Override
	public User getByUsername(String username) {
		return getUserDao().findByUsername(username).get(0);
	}

	@Transactional(readOnly=true)
	@Override
	public List<User> getUsers() {
		return (List<User>) getUserDao().findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		return this.getByUsername(username);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

}
