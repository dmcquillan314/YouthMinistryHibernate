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

	@Autowired
	private PageDao pageDao;
	
	@Transactional(readOnly=false)
	@Override
	public void addPage(Page page) {
		pageDao.create(page);
	}

	@Transactional(readOnly=false)
	@Override
	public void updatePage(Page page) {
		pageDao.update(page);
	}

	@Transactional(readOnly=false)
	@Override
	public void deletePage(Page page) {
		pageDao.delete(page);
	}

	@Transactional(readOnly=true)
	@Override
	public Page getPageById(Long id) {
		return (Page) pageDao.read(id);
	}

	@Override
	public List<Page> getPages() {
		// TODO Auto-generated method stub
		return pageDao.findAll();
	}
	
}
