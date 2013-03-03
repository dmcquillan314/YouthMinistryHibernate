package com.youthministry.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.youthministry.dao.PageContentDao;
import com.youthministry.domain.PageContent;

public class PageContentDaoImpl implements PageContentDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addPageContent(PageContent pageContent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePageContent(PageContent pageContent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePageContent(PageContent pageContent) {
		// TODO Auto-generated method stub

	}

	@Override
	public PageContent getPageContentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PageContent> getAllPageContent() {
		// TODO Auto-generated method stub
		return null;
	}

}
