package com.youthministry.service;

import java.util.ArrayList;
import java.util.List;

import com.youthministry.domain.Image;
import com.youthministry.domain.PageContent;
import com.youthministry.domain.TextEntry;

public interface PageContentService {
	
	/**
	 * Get PageContent Entrybyid 
	 * 
	 * @param Long id
	 */
	public PageContent getPageContentById(Long id);
	
	/**
	 * Add PageContent Entry
	 * 
	 * @param PageContent pageContent
	 */
	public void addPageContent(Object pageContent);
	
	/**
	 * Update PageContent Entry
	 * 
	 * @param PageContent pageContent
	 */
	public void updatePageContent(Object pageContent);
	
	/**
	 * Delete PageContent Entry
	 * 
	 * @param PageContent pageContent
	 */
	public void deletePageContent(Object pageContent);
	
	/**
	 * Get all PageContent Entries
	 * 
	 * @param 
	 */
	public ArrayList<? extends PageContent> getAllPageContent();

	ArrayList<? extends PageContent> getAllImageEntries();

	ArrayList<? extends PageContent> getAllTextEntries();

	List<? extends PageContent> getAllTextEntriesForGroup(String groupName);

	List<? extends PageContent> getAllImageEntriesForGroup(String groupName);
}
