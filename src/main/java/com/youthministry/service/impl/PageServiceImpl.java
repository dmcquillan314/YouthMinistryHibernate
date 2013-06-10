package com.youthministry.service.impl;

import java.util.ArrayList;

import com.youthministry.dao.PageDao;
import com.youthministry.domain.Page;
import com.youthministry.service.PageService;

public class PageServiceImpl implements PageService {

	private PageDao pageDao;
	
	public PageDao getPageDao() {
		return pageDao;
	}

	public void setPageDao(PageDao pageDao) {
		this.pageDao = pageDao;
	}

	@Override
	public void addPage(Object object) {
		getPageDao().addPage(object);
	}

	@Override
	public void updatePage(Object object) {
		getPageDao().updatePage(object);
	}

	@Override
	public void deletePage(Object object) {
		getPageDao().deletePage(object);
	}

	@Override
	public Page getPageById(long id) {
		return getPageDao().getPageById(id);
	}

	@Override
	public ArrayList<Page> getPages() {
		return getPageDao().getPages();
	}
	
}
