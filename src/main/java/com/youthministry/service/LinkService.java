package com.youthministry.service;

import com.youthministry.domain.Link;

public interface LinkService {
	
	public void create(Link link);
	
	public Link read(Link link);
	
	public void update(Link link);
	
	public void delete(Link link);
}
