package com.youthministry.dao;

import java.util.List;

import com.youthministry.domain.Page;
import com.youthministry.genericdao.GenericDao;

public interface PageDao extends GenericDao<Page, Long> {
	List<Page> findAll();
}
