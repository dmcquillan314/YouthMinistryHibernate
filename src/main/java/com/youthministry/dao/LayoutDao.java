package com.youthministry.dao;

import java.util.List;

import com.youthministry.domain.Layout;
import com.youthministry.genericdao.GenericDao;

public interface LayoutDao extends GenericDao<Layout, Long> {

	public List<Layout> findAll();
}
