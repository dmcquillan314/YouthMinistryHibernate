package com.youthministry.service;

import com.youthministry.domain.Template;

public interface TemplateService {

	public void create(Template template);
	public Template read(Long id);
	public void update(Template temmplate);
	public void delete(Template template);
	
}
