package com.youthministry.genericservice.impl;

import java.io.Serializable;

import com.youthministry.genericdao.GenericDao;
import com.youthministry.genericservice.GenericService;

public class GenericServiceImpl<T, PK extends Serializable> implements GenericService<T, PK> {

	private Class<T> type;
	
	private GenericDao genericDao;
	
	public GenericServiceImpl(Class<T> type) {
		this.type = type;
	}
	
	@Override
	public PK create(T newInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T read(PK id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(T transientObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T persistentObject) {
		// TODO Auto-generated method stub
		
	}

	public GenericDao getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}

}
