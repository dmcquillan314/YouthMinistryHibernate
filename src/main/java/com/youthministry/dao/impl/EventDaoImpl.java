package com.youthministry.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.youthministry.dao.EventDao;
import com.youthministry.domain.Event;

public class EventDaoImpl implements EventDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addEvent(Event event) {
		getSessionFactory().getCurrentSession().save(event);
	}

	@Override
	public void updateEvent(Event event) {
		getSessionFactory().getCurrentSession().update(event);
	}

	@Override
	public void deleteEvent(Event event) {
		getSessionFactory().getCurrentSession().delete(event);
	}

	@Override
	public Event getEventById(Long id) {
		List list = getSessionFactory().getCurrentSession().createQuery("from Event where eventId=?").setParameter(0, id).list();
		return (Event) list.get(0);
	}

	@Override
	public Event getEventByName(String name) {
		List list = getSessionFactory().getCurrentSession().createQuery("from Event where eventName=?").setParameter(0, name).list();
		return (Event) list.get(0);
	}

	@Override
	public List<Event> getEventsForGroup(String groupName) {
		return (List<Event>) getSessionFactory().getCurrentSession().createQuery("from Event e left join fetch e.groups g where g.groupName = ?").setParameter(0, groupName).list();
	}
	
	@Override
	public List<Event> getEvents() {
		return (List<Event>) getSessionFactory().getCurrentSession().createQuery("from Event").list();
	}


}
