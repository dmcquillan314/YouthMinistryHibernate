package com.youthministry.service;

import java.util.List;

import com.youthministry.domain.Menu;

public interface MenuService {
	
	public void create(Menu menu);
	
	public Menu read(Long id);
	
	public void update(Menu menu);
	
	public void delete(Menu menu);
	
	public List<Menu> getAll();

}
