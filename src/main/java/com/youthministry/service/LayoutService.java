package com.youthministry.service;

import java.util.List;

import com.youthministry.domain.Layout;

public interface LayoutService {

	public void create(Layout template);
	public Layout read(Long id);
	public void update(Layout temmplate);
	public void delete(Layout template);
	public List<Layout> findAll();
	
}
