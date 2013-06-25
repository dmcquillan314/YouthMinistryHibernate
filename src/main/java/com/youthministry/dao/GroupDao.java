package com.youthministry.dao;

import java.util.List;

import com.youthministry.domain.Group;
import com.youthministry.genericdao.GenericDao;

public interface GroupDao extends GenericDao<Group, Long> {
	List<Group> findByName(String name);
	List<Group> findAll();
}
