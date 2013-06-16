package com.youthministry.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.youthministry.domain.Role;
import com.youthministry.genericdao.GenericDao;
import com.youthministry.service.RoleService;

@Transactional(readOnly=true)
public class RoleServiceImpl implements RoleService {

	private GenericDao genericDao;
	
	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}
	
	public GenericDao getGenericDao() {
		return this.genericDao;
	}
	
	@Transactional(readOnly=false)
	@Override
	public void addRole(Role role) {
		getGenericDao().create(role);
	}

	@Transactional(readOnly=false)
	@Override
	public void updateRole(Role role) {
		getGenericDao().update(role);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteRole(Role role) {
		getGenericDao().delete(role);
	}

	@Transactional(readOnly=true)
	@Override
	public Role getRoleById(Long id) {
		return (Role) getGenericDao().read(id);
	}

	@Override
	public Role getRoleByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> getRoles() {
		// TODO Auto-generated method stub
		return null;
	}

}
