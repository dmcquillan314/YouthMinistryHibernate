package com.youthministry.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.youthministry.dao.RendererDao;
import com.youthministry.domain.Renderer;
import com.youthministry.service.RendererService;

@Transactional(readOnly=true)
public class RendererServiceImpl implements RendererService {

	private RendererDao rendererDao;
	
	public RendererDao getRendererDao() {
		return rendererDao;
	}

	public void setRendererDao(RendererDao rendererDao) {
		this.rendererDao = rendererDao;
	}

	@Transactional(readOnly=false)
	@Override
	public void create(Renderer renderer) {
		getRendererDao().create(renderer);
	}

	@Transactional(readOnly=true)
	@Override
	public Renderer read(Long id) {
		return getRendererDao().read(id);
	}

	@Transactional(readOnly=false)
	@Override
	public void update(Renderer renderer) {
		getRendererDao().update(renderer);
	}

	@Transactional(readOnly=false)
	@Override
	public void delete(Renderer renderer) {
		getRendererDao().delete(renderer);
	}

}
