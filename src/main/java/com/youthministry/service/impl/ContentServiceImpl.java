package com.youthministry.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.youthministry.dao.ContentDao;
import com.youthministry.domain.Content;
import com.youthministry.genericdao.GenericDao;
import com.youthministry.service.ContentService;

@Transactional(readOnly=true)
public class ContentServiceImpl implements ContentService {

	private ContentDao pageContentDao;
	
	public void setPageContentDao(ContentDao pageContentDao) {
		this.pageContentDao = pageContentDao;
	}
	
	public ContentDao getPageContentDao() {
		return pageContentDao;
	}
	
	@Transactional(readOnly=true)
	@Override
	public Content getPageContentById(Long id) {
		return (Content) getPageContentDao().read(id);
	}
	
	@Transactional(readOnly=false)
	@Override
	public void addPageContent(Content pageContent) {
		getPageContentDao().create(pageContent);
	}

	@Transactional(readOnly=false)
	@Override
	public void updatePageContent(Content pageContent) {
		getPageContentDao().update(pageContent);
	}

	@Transactional(readOnly=false)
	@Override
	public void deletePageContent(Content pageContent) {
		getPageContentDao().delete(pageContent);
	}

	@Override
	public List<Content> getAllPageContent() {
		// TODO Auto-generated method stub
		return getPageContentDao().findAll();
	}	

}
