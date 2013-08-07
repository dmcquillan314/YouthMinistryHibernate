package com.youthministry.service;

import java.util.List;

import com.youthministry.domain.File;

public interface FileService {
	
	public void create(File file);
	
	public File read(Long id);
	
	public void update(File file);
	
	public void delete(File file);
	
	public List<File> getAll();
	
}
