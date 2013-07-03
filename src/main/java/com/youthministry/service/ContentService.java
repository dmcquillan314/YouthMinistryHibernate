package com.youthministry.service;

import java.util.ArrayList;
import java.util.List;

import com.youthministry.domain.Image;
import com.youthministry.domain.Content;

public interface ContentService {
	
	/**
	 * Get PageContent Entrybyid 
	 * 
	 * @param Long id
	 */
	public Content getPageContentById(Long id);
	
	/**
	 * Add PageContent Entry
	 * 
	 * @param Content pageContent
	 */
	public void addPageContent(Content pageContent);
	
	/**
	 * Update PageContent Entry
	 * 
	 * @param Content pageContent
	 */
	public void updatePageContent(Content pageContent);
	
	/**
	 * Delete PageContent Entry
	 * 
	 * @param Content pageContent
	 */
	public void deletePageContent(Content pageContent);
	
	/**
	 * Get all PageContent Entries
	 * 
	 * @param 
	 */
	public List<Content> getAllPageContent();
}
