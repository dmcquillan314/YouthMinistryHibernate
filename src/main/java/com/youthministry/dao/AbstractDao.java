package com.youthministry.dao;

import java.util.ArrayList;

public abstract class AbstractDao {
	
	/**
	 * Create object
	 */
	public abstract void add(Object object);
	
	/**
	 * Update object
	 */
	public abstract void update(Object object);
	
	/**
	 * Delete object
	 */
	public abstract void delete(Long id);
	
	/**
	 * Get object by id
	 */
	public abstract Object getById(Long id);
	
	/**
	 * Get object by name
	 */
	public abstract Object getByName(String name);
	
	/**
	 * Get all objects
	 */
	public abstract ArrayList<? extends Object> getAll();
	
}
