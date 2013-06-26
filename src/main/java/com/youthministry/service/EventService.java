package com.youthministry.service;

import java.util.List;

import com.youthministry.domain.Event;

public interface EventService {

	/**
	 * Add Event
	 * 
	 * @param Event event
	 */
	public void addEvent(Event event);
	
	/**
	 * Update Event
	 * 
	 * @param Event event
	 */
	public void updateEvent(Event event);
	
	/**
	 * Delete Event
	 * 
	 * @param Event event
	 */
	public void deleteEvent(Event event);
	
	/**
	 * Get Event
	 * 
	 * @param Long Id
	 */
	public Event getEventById(Long id);
	
	/**
	 * Get Event by name
	 * 
	 * @param String name
	 */
	public Event getGroupByName(String name);
		
	/**
	 * Get all Events
	 * 
	 * @param void
	 */
	public List<Event> getEvents();
}
