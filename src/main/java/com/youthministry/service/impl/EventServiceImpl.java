package com.youthministry.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.youthministry.dao.EventDao;
import com.youthministry.domain.Event;
import com.youthministry.genericdao.GenericDao;
import com.youthministry.service.EventService;

@Transactional(readOnly=true)
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDao eventDao;
	
	@Transactional(readOnly=false)
	@Override
	public void addEvent(Event event) {
		eventDao.create(event);
	}

	@Transactional(readOnly=false)
	@Override
	public void updateEvent(Event event) {
		eventDao.update(event);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteEvent(Event event) {
		eventDao.delete(event);
	}

	@Transactional(readOnly=true)
	@Override
	public Event getEventById(Long id) {
		return (Event) eventDao.read(id);
	}

	@Override
	public Event getGroupByName(String name) {
		return eventDao.findByName(name).get(0);
	}

	@Override
	public List<Event> getEvents() {
		return eventDao.findAll();
	}

}
