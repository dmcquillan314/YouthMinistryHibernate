package com.youthministry.service;

import java.util.List;

import com.youthministry.domain.Link;

public interface LinkService {
	
	public void create(Link link);
	
	public Link read(Long id);
	
	public void update(Link link);
	
	public void delete(Link link);
	
	public List<Link> getAll();
	
}
