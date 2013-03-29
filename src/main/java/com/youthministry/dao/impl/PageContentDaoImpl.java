package com.youthministry.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.youthministry.dao.PageContentDao;
import com.youthministry.domain.Image;
import com.youthministry.domain.PageContent;
import com.youthministry.domain.TextEntry;

public class PageContentDaoImpl implements PageContentDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addPageContent(Object pageContent) {
		//if(pageContent instanceof TextEntry) {
			//TextEntry textEntry = (TextEntry) pageContent;
			getSessionFactory().getCurrentSession().save(pageContent);
		//} else if (pageContent instanceof Image) {
			//Image image = (Image) pageContent;			
			//getSessionFactory().getCurrentSession().save(image);
		//}
	}

	@Override
	public void updatePageContent(Object pageContent) {
		getSessionFactory().getCurrentSession().update(pageContent);
	}

	@Override
	public void deletePageContent(Object pageContent) {
		getSessionFactory().getCurrentSession().delete(pageContent);
	}

	@Override
	public PageContent getPageContentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PageContent> getAllPageContent() {
		ArrayList<PageContent> pageContentArray = (ArrayList<PageContent>) getSessionFactory().getCurrentSession().createQuery("from PageContent").list();
		return pageContentArray;
	}

}
