package com.youthministry.service;

import java.util.ArrayList;
import java.util.List;

import com.youthministry.domain.Page;

public interface PageService {
	
	public void addPage(Page page);
	
	public void updatePage(Page page);
	
	public void deletePage(Page page);
	
	public Page getPageById(Long id);
	
	public List<Page> getPages();
}
