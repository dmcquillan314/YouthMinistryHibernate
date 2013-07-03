package com.youthministry.dao;

import java.util.List;

import com.youthministry.domain.Content;
import com.youthministry.genericdao.GenericDao;

public interface ContentDao extends GenericDao<Content, Long> {
	List<Content> findAll();
}
