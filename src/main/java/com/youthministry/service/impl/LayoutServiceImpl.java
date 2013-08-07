package com.youthministry.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.youthministry.dao.LayoutDao;
import com.youthministry.domain.Layout;
import com.youthministry.service.LayoutService;

@Transactional(readOnly=true)
public class LayoutServiceImpl implements LayoutService {

	private LayoutDao layoutDao;
	
	public LayoutDao getLayoutDao() {
		return layoutDao;
	}

	public void setLayoutDao(LayoutDao layoutDao) {
		this.layoutDao = layoutDao;
	}

	@Transactional(readOnly=false)
	@Override
	public void create(Layout template) {
		getLayoutDao().create(template);
	}

	@Transactional(readOnly=true)
	@Override
	public Layout read(Long id) {
		return getLayoutDao().read(id);
	}

	@Transactional(readOnly=false)
	@Override
	public void update(Layout template) {
		getLayoutDao().update(template);
	}

	@Transactional(readOnly=false)
	@Override
	public void delete(Layout template) {
		getLayoutDao().delete(template);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Layout> findAll() {
		return getLayoutDao().findAll();
	}

}
