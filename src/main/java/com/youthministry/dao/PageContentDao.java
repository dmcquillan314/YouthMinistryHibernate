package com.youthministry.dao;

import java.util.List;

import com.youthministry.domain.PageContent;
import com.youthministry.genericdao.GenericDao;

public interface PageContentDao extends GenericDao<PageContent, Long> {
	List<PageContent> findAll();
}
