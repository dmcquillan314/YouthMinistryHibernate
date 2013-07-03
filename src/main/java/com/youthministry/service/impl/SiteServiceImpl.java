package com.youthministry.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.youthministry.dao.SiteDao;
import com.youthministry.domain.Site;
import com.youthministry.service.SiteService;

@Transactional(readOnly=true)
public class SiteServiceImpl implements SiteService {

	private SiteDao siteDao;
	
	public SiteDao getSiteDao() {
		return siteDao;
	}

	public void setSiteDao(SiteDao siteDao) {
		this.siteDao = siteDao;
	}

	@Transactional(readOnly=false)
	@Override
	public void create(Site site) {
		getSiteDao().create(site);
	}

	@Transactional(readOnly=true)
	@Override
	public Site read(Long id) {
		return getSiteDao().read(id);
	}

	@Transactional(readOnly=false)
	@Override
	public void update(Site site) {
		getSiteDao().update(site);
	}

	@Transactional(readOnly=false)
	@Override
	public void delete(Site site) {
		getSiteDao().delete(site);
	}

}
