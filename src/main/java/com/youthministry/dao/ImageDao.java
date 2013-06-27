package com.youthministry.dao;

import java.util.List;

import com.youthministry.domain.Event;
import com.youthministry.domain.Image;
import com.youthministry.genericdao.GenericDao;

public interface ImageDao extends GenericDao<Image, Long> {
	List<Image> findAll();
}
