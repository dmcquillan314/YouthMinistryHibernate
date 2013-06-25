package com.youthministry.dao;

import java.util.List;

import com.youthministry.domain.Event;
import com.youthministry.genericdao.GenericDao;

public interface EventDao extends GenericDao<Event, Long> {
	List<Event> findByName(String name);
	List<Event> findAll();
}
