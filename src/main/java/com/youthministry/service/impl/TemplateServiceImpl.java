package com.youthministry.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.youthministry.dao.TemplateDao;
import com.youthministry.domain.Template;
import com.youthministry.service.TemplateService;

@Transactional(readOnly=true)
public class TemplateServiceImpl implements TemplateService {

	private TemplateDao templateDao;
	
	public TemplateDao getTemplateDao() {
		return templateDao;
	}

	public void setTemplateDao(TemplateDao templateDao) {
		this.templateDao = templateDao;
	}

	@Transactional(readOnly=false)
	@Override
	public void create(Template template) {
		getTemplateDao().create(template);
	}

	@Transactional(readOnly=true)
	@Override
	public Template read(Long id) {
		return getTemplateDao().read(id);
	}

	@Transactional(readOnly=false)
	@Override
	public void update(Template template) {
		getTemplateDao().update(template);
	}

	@Transactional(readOnly=false)
	@Override
	public void delete(Template template) {
		getTemplateDao().delete(template);
	}

}
