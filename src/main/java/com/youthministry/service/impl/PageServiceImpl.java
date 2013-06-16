package com.youthministry.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.youthministry.domain.Page;
import com.youthministry.genericdao.GenericDao;
import com.youthministry.service.PageService;

@Transactional(readOnly=true)
public class PageServiceImpl implements PageService {

	private GenericDao genericDao;
	
	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}
	
	public GenericDao getGenericDao() {
		return this.genericDao;
	}

	@Transactional(readOnly=false)
	@Override
	public void addPage(Object object) {
		getGenericDao().create(object);
	}

	@Transactional(readOnly=false)
	@Override
	public void updatePage(Object object) {
		getGenericDao().update(object);
	}

	@Transactional(readOnly=false)
	@Override
	public void deletePage(Object object) {
		getGenericDao().delete(object);
	}

	@Transactional(readOnly=true)
	@Override
	public Page getPageById(long id) {
		return (Page) getGenericDao().read(id);
	}

	@Override
	public List<Page> getPages() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
