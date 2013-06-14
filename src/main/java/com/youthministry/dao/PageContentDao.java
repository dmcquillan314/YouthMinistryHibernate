package com.youthministry.dao;

import java.util.List;

import com.youthministry.domain.Image;
import com.youthministry.domain.PageContent;
import com.youthministry.domain.TextEntry;

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
    public PageContent getPageContentById(Long id);
        
 
    /**
     * Get Event List
     *
     */
    public List<? extends PageContent> getAllPageContent();

	List<TextEntry> getAllTextEntries();

	List<Image> getAllImageEntries();

	List<TextEntry> getAllTextEntriesForGroup(String groupName);

	List<Image> getAllImageEntriesForGroup(String groupName);

}
