package com.youthministry.dao;

import java.util.List;

import com.youthministry.domain.Renderer;
import com.youthministry.genericdao.GenericDao;

public interface RendererDao extends GenericDao<Renderer, Long> {
	List<Renderer> findAll();
	List<Renderer> findByName(String name);
}
