package com.youthministry.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.youthministry.dao.UserDao;
import com.youthministry.domain.User;
import com.youthministry.domain.Group;
import com.youthministry.domain.Role;
import com.youthministry.domain.UserProfile;
import com.youthministry.genericdao.GenericDao;
import com.youthministry.service.UserService;

@Transactional(readOnly=true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Transactional(readOnly=false)
	@Override
	public void addUser(User user) {
		userDao.create(user);
	}

	@Transactional(readOnly=false)
	@Override
	public void updateUser(User user) {
		User uTemp = (User) userDao.read(user.getUserId());
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
		//System.out.println("update user");
		userDao.update(uTemp);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteUser(User user) {
		userDao.delete(user);
	}

	@Transactional(readOnly=true)
	@Override
	public User getByUserId(Long id) {
		return (User) userDao.read(id);
	}

	@Override
	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		return (User) userDao.findByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return (List<User>) userDao.findAll();
	}

}
