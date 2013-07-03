package com.youthministry.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.youthministry.dao.LocationDao;
import com.youthministry.domain.Location;
import com.youthministry.service.LocationService;

@Transactional(readOnly=true)
public class LocationServiceImpl implements LocationService {

	private LocationDao locationDao;
	
	public LocationDao getLocationDao() {
		return locationDao;
	}

	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}

	@Transactional(readOnly=false)
	@Override
	public void create(Location location) {
		getLocationDao().create(location);
	}

	@Transactional(readOnly=true)
	@Override
	public Location read(Long id) {
		return getLocationDao().read(id);
	}

	@Transactional(readOnly=false)
	@Override
	public void update(Location location) {
		getLocationDao().update(location);
	}

	@Transactional(readOnly=false)
	@Override
	public void delete(Location location) {
		getLocationDao().delete(location);
	}

}
