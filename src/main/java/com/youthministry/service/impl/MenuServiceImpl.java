package com.youthministry.service.impl;

import com.youthministry.dao.MenuDao;
import com.youthministry.domain.Menu;
import com.youthministry.service.MenuService;

public class MenuServiceImpl implements MenuService {

	private MenuDao menuDao;
	
	public MenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	@Override
	public void create(Menu menu) {
		getMenuDao().create(menu);
	}

	@Override
	public Menu read(Long id) {
		return getMenuDao().read(id);
	}

	@Override
	public void update(Menu menu) {
		getMenuDao().update(menu);
	}

	@Override
	public void delete(Menu menu) {
		getMenuDao().delete(menu);
	}

}
