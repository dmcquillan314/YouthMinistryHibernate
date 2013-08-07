package com.youthministry.dao.upload;

import java.util.List;

import com.youthministry.domain.File;
import com.youthministry.genericdao.GenericDao;

public interface FileDao extends GenericDao<File, Long>{
	
	public List<File> findAll();
}
