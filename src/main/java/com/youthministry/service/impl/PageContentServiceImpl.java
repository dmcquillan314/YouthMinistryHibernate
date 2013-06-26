package com.youthministry.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.youthministry.dao.PageContentDao;
import com.youthministry.domain.PageContent;
import com.youthministry.genericdao.GenericDao;
import com.youthministry.service.PageContentService;

@Transactional(readOnly=true)
public class PageContentServiceImpl implements PageContentService {

	private PageContentDao pageContentDao;
	
	public void setPageContentDao(PageContentDao pageContentDao) {
		this.pageContentDao = pageContentDao;
	}
	
	public PageContentDao getPageContentDao() {
		return pageContentDao;
	}
	
	@Transactional(readOnly=true)
	@Override
	public PageContent getPageContentById(Long id) {
		return (PageContent) getPageContentDao().read(id);
	}
	
	@Transactional(readOnly=false)
	@Override
	public void addPageContent(PageContent pageContent) {
		getPageContentDao().create(pageContent);
	}

	@Transactional(readOnly=false)
	@Override
	public void updatePageContent(PageContent pageContent) {
		getPageContentDao().update(pageContent);
	}

	@Transactional(readOnly=false)
	@Override
	public void deletePageContent(PageContent pageContent) {
		getPageContentDao().delete(pageContent);
	}

	@Override
	public List<PageContent> getAllPageContent() {
		// TODO Auto-generated method stub
		return getPageContentDao().findAll();
	}	

}
