package com.youthministry.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.youthministry.dao.ImageDao;
import com.youthministry.domain.Image;
import com.youthministry.service.ImageService;

@Transactional(readOnly=true)
public class ImageServiceImpl implements ImageService {
	
	private ImageDao imageDao;
	
	public void setImageDao(ImageDao imageDao) {
		this.imageDao = imageDao;
	}
	public ImageDao getImageDao() {
		return imageDao;
	}
	
	@Transactional(readOnly=false)
	@Override
	public Long create(Image image) {
		return getImageDao().create(image);
	}
	
	@Transactional(readOnly=true)
	@Override
	public Image read(Long id) {
		return getImageDao().read(id);
	}
	
	@Transactional(readOnly=false)
	@Override
	public void update(Image image) {
		getImageDao().update(image);
	}
	
	@Transactional(readOnly=false)
	@Override
	public void delete(Image image) {
		getImageDao().delete(image);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<Image> getAll() {
		return getImageDao().findAll();
	}
	

}
