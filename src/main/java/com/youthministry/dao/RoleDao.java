package com.youthministry.dao;

import java.util.List;

import com.youthministry.domain.Role;
import com.youthministry.genericdao.GenericDao;

public interface RoleDao extends GenericDao<Role, Long> {
	List<Role> findByName(String name);
	List<Role> findAll();
}
