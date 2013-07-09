package com.youthministry.dao;

import java.util.List;

import com.youthministry.domain.Link;
import com.youthministry.genericdao.GenericDao;

public interface LinkDao extends GenericDao<Link, Long> {
	List<Link> findAll();
	List<Link> findByName(String name);
}
