package com.youthministry.dao;

import java.util.List;

import com.youthministry.domain.PageContent;

public interface PageContentDao {
    /**
     * Add Event
     *
     * @param  Event Event
     */
    public void addPageContent(Object pageContent);
 
    /**
     * Update Event
     *
     * @param  Event Event
     */
    public void updatePageContent(Object pageContent);
 
    /**
     * Delete Event
     *
     * @param  Event Event
     */
    public void deletePageContent(Object pageContent);
    
    /**
     * Get Event
     *
     * @param  int Event Id
     */
    public PageContent getPageContentById(int id);
        
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
    public List<? extends PageContent> getAllPageContent();

}
