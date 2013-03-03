package com.youthministry.dao;

import java.util.List;

import com.youthministry.domain.PageContent;

public interface PageContentDao {
    /**
     * Add Event
     *
     * @param  Event Event
     */
    public void addPageContent(PageContent pageContent);
 
    /**
     * Update Event
     *
     * @param  Event Event
     */
    public void updatePageContent(PageContent pageContent);
 
    /**
     * Delete Event
     *
     * @param  Event Event
     */
    public void deletePageContent(PageContent pageContent);
    
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
    public List<PageContent> getAllPageContent();

}
