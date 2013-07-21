package com.youthministry.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.youthministry.dao.TemplateDao;
import com.youthministry.domain.Layout;
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
	public void create(Layout template) {
		getTemplateDao().create(template);
	}

	@Transactional(readOnly=true)
	@Override
	public Layout read(Long id) {
		return getTemplateDao().read(id);
	}

	@Transactional(readOnly=false)
	@Override
	public void update(Layout template) {
		getTemplateDao().update(template);
	}

	@Transactional(readOnly=false)
	@Override
	public void delete(Layout template) {
		getTemplateDao().delete(template);
	}

}
