package com.youthministry.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.youthministry.dao.LinkDao;
import com.youthministry.domain.Link;
import com.youthministry.service.LinkService;

@Transactional(readOnly=true)
public class LinkServiceImpl implements LinkService {

	private LinkDao linkDao;
	
	public LinkDao getLinkDao() {
		return linkDao;
	}

	public void setLinkDao(LinkDao linkDao) {
		this.linkDao = linkDao;
	}

	@Override
	@Transactional(readOnly=false)
	public void create(Link link) {
		getLinkDao().create(link);
	}

	@Override
	@Transactional(readOnly=true)
	public Link read(Long id) {
		return getLinkDao().read(id);
	}

	@Override
	@Transactional(readOnly=false)
	public void update(Link link) {
		getLinkDao().update(link);
	}

	@Override
	@Transactional(readOnly=false)
	public void delete(Link link) {
		getLinkDao().delete(link);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Link> getAll() {
		return getLinkDao().findAll();
	}

}
