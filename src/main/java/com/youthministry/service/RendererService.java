package com.youthministry.service;

import java.util.List;

import com.youthministry.domain.Renderer;

public interface RendererService {

	public void create(Renderer renderer);
	public Renderer read(Long id);
	public void update(Renderer renderer);
	public void delete(Renderer renderer);
	public List<Renderer> getAll();
}
