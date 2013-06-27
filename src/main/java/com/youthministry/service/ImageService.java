package com.youthministry.service;

import java.util.List;

import com.youthministry.dao.ImageDao;
import com.youthministry.domain.Image;

public interface ImageService {
	public Long create(Image image);
	
	public Image read(Long id);
	
	public void update(Image image);
	
	public void delete(Image image);
	
	public List<Image> getAll();
	
}
