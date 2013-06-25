package com.youthministry.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.youthministry.dao.RoleDao;
import com.youthministry.domain.Role;
import com.youthministry.genericdao.GenericDao;
import com.youthministry.service.RoleService;

@Transactional(readOnly=true)
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Transactional(readOnly=false)
	@Override
	public void addRole(Role role) {
		roleDao.create(role);
	}

	@Transactional(readOnly=false)
	@Override
	public void updateRole(Role role) {
		roleDao.update(role);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteRole(Role role) {
		roleDao.delete(role);
	}

	@Transactional(readOnly=true)
	@Override
	public Role getRoleById(Long id) {
		return (Role) roleDao.read(id);
	}

	@Override
	public Role getRoleByName(String name) {
		return roleDao.findByName(name).get(0);
	}

	@Override
	public List<Role> getRoles() {
		return roleDao.findAll();
	}

}
