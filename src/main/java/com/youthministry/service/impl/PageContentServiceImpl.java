package com.youthministry.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.youthministry.domain.PageContent;
import com.youthministry.genericdao.GenericDao;
import com.youthministry.service.PageContentService;

@Transactional(readOnly=true)
public class PageContentServiceImpl implements PageContentService {

	private GenericDao genericDao;
	
	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}
	
	public GenericDao getGenericDao() {
		return this.genericDao;
	}

	@Transactional(readOnly=true)
	@Override
	public PageContent getPageContentById(Long id) {
		return (PageContent) getGenericDao().read(id);
	}
	
	@Transactional(readOnly=false)
	@Override
	public void addPageContent(Object pageContent) {
		getGenericDao().create(pageContent);
	}

	@Transactional(readOnly=false)
	@Override
	public void updatePageContent(Object pageContent) {
		getGenericDao().update(pageContent);
	}

	@Transactional(readOnly=false)
	@Override
	public void deletePageContent(Object pageContent) {
		getGenericDao().delete(pageContent);
	}

	@Override
	public ArrayList<? extends PageContent> getAllPageContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<? extends PageContent> getAllImageEntries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<? extends PageContent> getAllTextEntries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends PageContent> getAllTextEntriesForGroup(
			String groupName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends PageContent> getAllImageEntriesForGroup(
			String groupName) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
