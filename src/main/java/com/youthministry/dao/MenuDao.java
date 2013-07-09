package com.youthministry.dao;

import java.util.List;

import com.youthministry.domain.Menu;
import com.youthministry.genericdao.GenericDao;

public interface MenuDao extends GenericDao<Menu, Long> {
	List<Menu> findAll();
	List<Menu> findByName(String name);
}
