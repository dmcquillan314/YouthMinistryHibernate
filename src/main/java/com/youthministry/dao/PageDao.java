package com.youthministry.dao;

import java.util.ArrayList;
import java.util.List;

import com.youthministry.domain.Page;

public interface PageDao {
	
	public void addPage(Object object);
	
	public void updatePage(Object object);
	
	public void deletePage(Object object);
	
	public Page getPageById(long id);
	
	public List<Page> getPages();
}