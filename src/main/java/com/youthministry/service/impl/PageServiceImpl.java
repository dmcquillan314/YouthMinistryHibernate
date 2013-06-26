package com.youthministry.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.youthministry.dao.PageDao;
import com.youthministry.domain.Page;
import com.youthministry.genericdao.GenericDao;
import com.youthministry.service.PageService;

@Transactional(readOnly=true)
public class PageServiceImpl implements PageService {

	private PageDao pageDao;
	
	public void setPageDao(PageDao pageDao) {
		this.pageDao = pageDao;
	}
	
	public PageDao getPageDao() {
		return pageDao;
	}
	
	@Transactional(readOnly=false)
	@Override
	public void addPage(Page page) {
		getPageDao().create(page);
	}

	@Transactional(readOnly=false)
	@Override
	public void updatePage(Page page) {
		getPageDao().update(page);
	}

	@Transactional(readOnly=false)
	@Override
	public void deletePage(Page page) {
		getPageDao().delete(page);
	}

	@Transactional(readOnly=true)
	@Override
	public Page getPageById(Long id) {
		return (Page) getPageDao().read(id);
	}

	@Override
	public List<Page> getPages() {
		// TODO Auto-generated method stub
		return getPageDao().findAll();
	}
	
}
