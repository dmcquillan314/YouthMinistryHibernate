package com.youthministry.dao;

import com.youthministry.domain.Event;

import java.util.List;

public interface EventDao {
    /**
     * Add Event
     *
     * @param  Event Event
     */
    public void addEvent(Event event);
 
    /**
     * Update Event
     *
     * @param  Event Event
     */
    public void updateEvent(Event event);
 
    /**
     * Delete Event
     *
     * @param  Event Event
     */
    public void deleteEvent(Event event);
    
    /**
     * Get Event
     *
     * @param  int Event Id
     */
    public Event getEventById(Long id);
    
    /**
     * Get Event
     *
     * @param  int Event Id
     */
    public Event getEventByName(String name);
    
    /*
     * Get Event By Group
     * 
     * @param int group name
     */
    public List<Event> getEventsForGroup(String groupName);
    
    /**TODO
     * Get Event
     *
     * @param  int Event Id
     *
    public Event getEventsBetween(Date startDate, Date endDate);*/
 
    /**
     * Get Event List
     *
     */
    public List<Event> getEvents();
}
