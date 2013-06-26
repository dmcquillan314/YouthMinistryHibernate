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

	private RoleDao roleDao;
	
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	
	public RoleDao getRoleDao() {
		return roleDao;
	}
	
	@Transactional(readOnly=false)
	@Override
	public void addRole(Role role) {
		getRoleDao().create(role);
	}

	@Transactional(readOnly=false)
	@Override
	public void updateRole(Role role) {
		getRoleDao().update(role);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteRole(Role role) {
		getRoleDao().delete(role);
	}

	@Transactional(readOnly=true)
	@Override
	public Role getRoleById(Long id) {
		return (Role) getRoleDao().read(id);
	}

	@Override
	public Role getRoleByName(String name) {
		return getRoleDao().findByName(name).get(0);
	}

	@Override
	public List<Role> getRoles() {
		return getRoleDao().findAll();
	}

}
