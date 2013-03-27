package com.youthministry.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.youthministry.dao.PageContentDao;
import com.youthministry.domain.PageContent;
import com.youthministry.service.PageContentService;

@Transactional(readOnly=true)
public class PageContentServiceImpl implements PageContentService {

	private PageContentDao pageContentDao;
	
	@Transactional(readOnly=false)
	@Override
	public void addPageContent(PageContent pageContent) {
		getPageContentDao().addPageContent(pageContent);
	}

	@Transactional(readOnly=false)
	@Override
	public void updatePageContent(PageContent pageContent) {
		getPageContentDao().updatePageContent(pageContent);
	}

	@Transactional(readOnly=false)
	@Override
	public void deletePageContent(PageContent pageContent) {
		getPageContentDao().deletePageContent(pageContent);
	}

	public PageContentDao getPageContentDao() {
		return pageContentDao;
	}

	public void setPageContentDao(PageContentDao pageContentDao) {
		this.pageContentDao = pageContentDao;
	}

}
