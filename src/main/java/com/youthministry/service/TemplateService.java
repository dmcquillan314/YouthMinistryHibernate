package com.youthministry.service;

import com.youthministry.domain.Layout;

public interface TemplateService {

	public void create(Layout template);
	public Layout read(Long id);
	public void update(Layout temmplate);
	public void delete(Layout template);
	
}
