package com.youthministry.service.impl;

import com.youthministry.dao.LinkDao;
import com.youthministry.domain.Link;
import com.youthministry.service.LinkService;

public class LinkServiceImpl implements LinkService {

	private LinkDao linkDao;
	
	public LinkDao getLinkDao() {
		return linkDao;
	}

	public void setLinkDao(LinkDao linkDao) {
		this.linkDao = linkDao;
	}

	@Override
	public void create(Link link) {

	}

	@Override
	public Link read(Link link) {
		return null;
	}

	@Override
	public void update(Link link) {

	}

	@Override
	public void delete(Link link) {

	}

}
