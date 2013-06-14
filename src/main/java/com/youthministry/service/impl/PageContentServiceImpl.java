package com.youthministry.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.youthministry.dao.PageContentDao;
import com.youthministry.domain.PageContent;
import com.youthministry.service.PageContentService;

@Transactional(readOnly=true)
public class PageContentServiceImpl implements PageContentService {

	private PageContentDao pageContentDao;

	@Transactional(readOnly=true)
	@Override
	public PageContent getPageContentById(Long id) {
		return getPageContentDao().getPageContentById(id);
	}
	
	@Transactional(readOnly=false)
	@Override
	public void addPageContent(Object pageContent) {
		getPageContentDao().addPageContent(pageContent);
	}

	@Transactional(readOnly=false)
	@Override
	public void updatePageContent(Object pageContent) {
		getPageContentDao().updatePageContent(pageContent);
	}

	@Transactional(readOnly=false)
	@Override
	public void deletePageContent(Object pageContent) {
		getPageContentDao().deletePageContent(pageContent);
	}
	
	@Transactional(readOnly=true)
	@Override
	public ArrayList<? extends PageContent> getAllPageContent() {
		return (ArrayList<? extends PageContent>) getPageContentDao().getAllPageContent();
	}

	@Transactional(readOnly=true)
	@Override
	public ArrayList<? extends PageContent> getAllTextEntries() {
		return (ArrayList<? extends PageContent>) getPageContentDao().getAllTextEntries();
	}

	@Transactional(readOnly=true)
	@Override
	public ArrayList<? extends PageContent> getAllImageEntries() {
		return (ArrayList<? extends PageContent>) getPageContentDao().getAllImageEntries();
	}

	@Override
	public List<? extends PageContent> getAllTextEntriesForGroup(String groupName) {
		return (ArrayList<? extends PageContent>) getPageContentDao().getAllTextEntriesForGroup(groupName);
	}

	@Override
	public List<? extends PageContent> getAllImageEntriesForGroup(String groupName) {
		return (ArrayList<? extends PageContent>) getPageContentDao().getAllImageEntriesForGroup(groupName);
	}

	public PageContentDao getPageContentDao() {
		return pageContentDao;
	}

	public void setPageContentDao(PageContentDao pageContentDao) {
		this.pageContentDao = pageContentDao;
	}

}
