package com.youthministry.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.youthministry.dao.PageDao;
import com.youthministry.domain.Page;
import com.youthministry.domain.PageContent;

public class PageDaoImpl implements PageDao {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addPage(Object page) {
		getSessionFactory().getCurrentSession().save(page);
	}

	@Override
	public void updatePage(Object page) {
		getSessionFactory().getCurrentSession().merge(page);
	}

	@Override
	public void deletePage(Object page) {
		getSessionFactory().getCurrentSession().delete(page);
	}

	@Override
	public Page getPageById(long id) {
		List list = getSessionFactory().getCurrentSession().createQuery("from PAGE where pageId=?").setParameter(0, id).list();
		return (Page) list.get(0);
	}

	@Override
	public List<Page> getPages() {
		List list = getSessionFactory().getCurrentSession().createQuery("from PAGE").list();
		return (List<Page>) list;
	}

}
