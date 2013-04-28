package com.youthministry.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.youthministry.dao.RoleDao;
import com.youthministry.domain.Role;
import com.youthministry.service.RoleService;

@Transactional(readOnly=true)
public class RoleServiceImpl implements RoleService {

	private RoleDao roleDao;
	
	@Transactional(readOnly=false)
	@Override
	public void addRole(Role role) {
		getRoleDao().addRole(role);
	}

	@Transactional(readOnly=false)
	@Override
	public void updateRole(Role role) {
		getRoleDao().updateRole(role);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteRole(Role role) {
		getRoleDao().deleteRole(role);
	}

	@Transactional(readOnly=true)
	@Override
	public Role getRoleById(Long id) {
		return getRoleDao().getRoleById(id);
	}

	@Transactional(readOnly=true)
	@Override
	public Role getRoleByName(String name) {
		return getRoleDao().getRoleByName(name);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Role> getRoles() {
		return getRoleDao().getRoles();
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

}
