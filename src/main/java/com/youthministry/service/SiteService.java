package com.youthministry.service;

import com.youthministry.domain.Site;

public interface SiteService {

	public void create(Site site);
	public Site read(Long id);
	public void update(Site site);
	public void delete(Site site);
	
}
