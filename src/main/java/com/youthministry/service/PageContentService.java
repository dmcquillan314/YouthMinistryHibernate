package com.youthministry.service;

import com.youthministry.domain.PageContent;

public interface PageContentService {
	
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
}
