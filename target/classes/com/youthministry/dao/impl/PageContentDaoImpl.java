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
		getSessionFactory().getCurrentSession().save(pageContent);
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
	public List<? extends PageContent> getAllPageContent() {
		ArrayList<? extends PageContent> pageContentArray = (ArrayList<PageContent>) getSessionFactory().getCurrentSession().createQuery("from PageContent").list();
		return pageContentArray;
	}
	
	@Override 
	public List<TextEntry> getAllTextEntries() {
		ArrayList<TextEntry> textEntryArray = (ArrayList<TextEntry>) getSessionFactory().getCurrentSession().createQuery("from TextEntry").list();
		return textEntryArray;
	}
	
	@Override 
	public List<Image> getAllImageEntries() {
		ArrayList<Image> imageEntryArray = (ArrayList<Image>) getSessionFactory().getCurrentSession().createQuery("from Image").list();
		return imageEntryArray;
	}

}
