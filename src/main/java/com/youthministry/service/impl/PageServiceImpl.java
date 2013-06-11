package com.youthministry.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.youthministry.dao.PageDao;
import com.youthministry.domain.Page;
import com.youthministry.service.PageService;

@Transactional(readOnly=true)
public class PageServiceImpl implements PageService {

	private PageDao pageDao;
	
	public PageDao getPageDao() {
		return pageDao;
	}

	public void setPageDao(PageDao pageDao) {
		this.pageDao = pageDao;
	}

	@Transactional(readOnly=false)
	@Override
	public void addPage(Object object) {
		getPageDao().addPage(object);
	}

	@Transactional(readOnly=false)
	@Override
	public void updatePage(Object object) {
		getPageDao().updatePage(object);
	}

	@Transactional(readOnly=false)
	@Override
	public void deletePage(Object object) {
		getPageDao().deletePage(object);
	}

	@Transactional(readOnly=true)
	@Override
	public Page getPageById(long id) {
		return getPageDao().getPageById(id);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Page> getPages() {
		return getPageDao().getPages();
	}
	
}
