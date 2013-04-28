package com.youthministry.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.youthministry.dao.UserDao;
import com.youthministry.domain.User;
import com.youthministry.domain.Group;
import com.youthministry.domain.Role;
import com.youthministry.domain.UserProfile;
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
		User uTemp = getUserDao().getUserById(user.getUserId());
		if(user.getPassword() != null && !"".equals(user.getPassword())) {
			uTemp.setPassword(user.getPassword());
		}
		if(user.getGroups() != null && user.getGroups().size() > 0) {
			ArrayList<Group> uGroups = (ArrayList<Group>) user.getGroups();
			uTemp.setGroups(uGroups);
		}
		if(user.getRoles() != null && user.getRoles().size() > 0) {
			ArrayList<Role> uRoles = (ArrayList<Role>) user.getRoles();
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
		System.out.println("update user");
		//getUserDao().updateUser(user);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteUser(User user) {
		getUserDao().deleteUser(user);
	}

	@Transactional(readOnly=true)
	@Override
	public User getUserByName(String username) {
		return getUserDao().getUserByName(username);
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
