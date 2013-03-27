package com.youthministry.service;

import com.youthministry.domain.PageContent;

public interface PageContentService {
	
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
}
