package com.youthministry.service;

import com.youthministry.domain.Location;

public interface LocationService {

	public void create(Location location);
	public Location read(Long id);
	public void update(Location location);
	public void delete(Location location);
	
}
