package com.youthministry.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.youthministry.dao.upload.FileDao;
import com.youthministry.domain.File;
import com.youthministry.service.FileService;

@Transactional(readOnly=true)
public class FileServiceImpl implements FileService {

	private FileDao fileDao;
	
	public FileDao getFileDao() {
		return fileDao;
	}

	public void setFileDao(FileDao fileDao) {
		this.fileDao = fileDao;
	}

	@Override
	@Transactional(readOnly=false)
	public void create(File file) {
		getFileDao().create(file);
	}

	@Override
	@Transactional(readOnly=true)
	public File read(Long id) {
		return getFileDao().read(id);
	}

	@Override
	@Transactional(readOnly=false)
	public void update(File file) {
		getFileDao().update(file);
	}

	@Override
	@Transactional(readOnly=false)
	public void delete(File file) {
		getFileDao().delete(file);
	}

	@Override
	@Transactional(readOnly=true)
	public List<File> getAll() {
		return getFileDao().findAll();
	}

}
