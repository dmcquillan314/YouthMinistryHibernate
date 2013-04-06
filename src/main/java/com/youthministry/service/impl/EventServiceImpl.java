package com.youthministry.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.youthministry.dao.EventDao;
import com.youthministry.domain.Event;
import com.youthministry.service.EventService;

@Transactional(readOnly=true)
public class EventServiceImpl implements EventService {

	private EventDao eventDao;
	
	@Transactional(readOnly=false)
	@Override
	public void addEvent(Event event) {
		getEventDao().addEvent(event);
	}

	@Transactional(readOnly=false)
	@Override
	public void updateEvent(Event event) {
		getEventDao().updateEvent(event);
	}

	@Transactional(readOnly=false)
	@Override
	public void deleteEvent(Event event) {
		getEventDao().deleteEvent(event);
	}

	@Transactional(readOnly=true)
	@Override
	public Event getEventById(Long id) {
		return getEventDao().getEventById(id);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<Event> getEventsForGroup(String groupName) {
		return getEventDao().getEventsForGroup(groupName);
	}

	@Transactional(readOnly=true)
	@Override
	public Event getGroupByName(String name) {
		return getEventDao().getEventByName(name);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Event> getEvents() {
		return getEventDao().getEvents();
	}

	public EventDao getEventDao() {
		return eventDao;
	}

	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}

}
