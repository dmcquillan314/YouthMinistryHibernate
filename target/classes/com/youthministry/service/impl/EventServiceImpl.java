package com.youthministry.service.impl;

import java.util.List;

import com.youthministry.dao.EventDao;
import com.youthministry.domain.Event;
import com.youthministry.service.EventService;

public class EventServiceImpl implements EventService {

	private EventDao eventDao;
	
	@Override
	public void addEvent(Event event) {
		getEventDao().addEvent(event);
	}

	@Override
	public void updateEvent(Event event) {
		getEventDao().updateEvent(event);
	}

	@Override
	public void deleteEvent(Event event) {
		getEventDao().deleteEvent(event);
	}

	@Override
	public Event getEventById(Long id) {
		return getEventDao().getEventById(id);
	}

	@Override
	public Event getGroupByName(String name) {
		return getEventDao().getEventByName(name);
	}

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
