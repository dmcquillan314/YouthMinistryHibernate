package com.youthministry.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.youthministry.domain.Event;
import com.youthministry.genericdao.GenericDao;
import com.youthministry.service.EventService;

@Transactional(readOnly=true)
public class EventServiceImpl implements EventService {

	private GenericDao genericDao;
	
	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}
	
	public GenericDao getGenericDao() {
		return this.genericDao;
	}
	
	@Transactional(readOnly=false)
	@Override
	public void addEvent(Event event) {
		getGenericDao().create(event);
	}

	@Transactional(readOnly=false)
	@Override
	public void updateEvent(Event event) {
		getGenericDao().update(event);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteEvent(Event event) {
		getGenericDao().delete(event);
	}

	@Transactional(readOnly=true)
	@Override
	public Event getEventById(Long id) {
		return (Event) getGenericDao().read(id);
	}

	@Override
	public Event getGroupByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getEventsForGroup(String groupName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getEvents() {
		// TODO Auto-generated method stub
		return null;
	}

}
