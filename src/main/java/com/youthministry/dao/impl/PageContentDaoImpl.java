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
		getSessionFactory().getCurrentSession().merge(pageContent);
	}

	@Override
	public void deletePageContent(Object pageContent) {
		getSessionFactory().getCurrentSession().delete(pageContent);
	}

	@Override
	public PageContent getPageContentById(Long id) {
		List list = getSessionFactory().getCurrentSession().createQuery("from PAGE_CONTENT where pageContentId=?").setParameter(0, id).list();
		return (PageContent) list.get(0);
	}

	@Override
	public List<? extends PageContent> getAllPageContent() {
		ArrayList<? extends PageContent> pageContentArray = (ArrayList<PageContent>) getSessionFactory().getCurrentSession().createQuery("from PAGE_CONTENT").list();
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

	@Override
	public List<TextEntry> getAllTextEntriesForGroup(String groupName) {
		return (List<TextEntry>) getSessionFactory().getCurrentSession().createQuery("from TextEntry t left join fetch t.groups g where g.groupName = ?").setParameter(0, groupName).list();
	}

	@Override
	public List<Image> getAllImageEntriesForGroup(String groupName) {
		return (List<Image>) getSessionFactory().getCurrentSession().createQuery("from Image i left join fetch i.groups g where g.groupName = ?").setParameter(0, groupName).list();
	}

}