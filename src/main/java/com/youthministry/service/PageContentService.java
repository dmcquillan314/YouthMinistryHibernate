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
	public void addPageContent(PageContent pageContent);
	
	/**
	 * Update PageContent Entry
	 * 
	 * @param PageContent pageContent
	 */
	public void updatePageContent(PageContent pageContent);
	
	/**
	 * Delete PageContent Entry
	 * 
	 * @param PageContent pageContent
	 */
	public void deletePageContent(PageContent pageContent);
	
	/**
	 * Get all PageContent Entries
	 * 
	 * @param 
	 */
	public List<PageContent> getAllPageContent();
}
