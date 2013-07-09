package com.youthministry.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.youthministry.dao.MenuDao;
import com.youthministry.domain.Menu;
import com.youthministry.service.MenuService;

@Transactional(readOnly=true)
public class MenuServiceImpl implements MenuService {

	private MenuDao menuDao;
	
	public MenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	@Override
	@Transactional(readOnly=false)
	public void create(Menu menu) {
		getMenuDao().create(menu);
	}

	@Override
	@Transactional(readOnly=true)
	public Menu read(Long id) {
		return getMenuDao().read(id);
	}

	@Override
	@Transactional(readOnly=false)
	public void update(Menu menu) {
		getMenuDao().update(menu);
	}

	@Override
	@Transactional(readOnly=false)
	public void delete(Menu menu) {
		getMenuDao().delete(menu);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Menu> getAll() {
		return getMenuDao().findAll();
	}

}
