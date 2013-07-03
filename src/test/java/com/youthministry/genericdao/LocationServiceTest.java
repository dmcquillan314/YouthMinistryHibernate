package com.youthministry.genericdao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.youthministry.domain.Location;
import com.youthministry.service.LocationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "root-context.xml"}) 
@TransactionConfiguration
@Transactional
public class LocationServiceTest {

	@Autowired
	protected LocationService LocationService;
	
	final Logger logger = LoggerFactory.getLogger(LocationServiceTest.class);
	
	public Long testCreateLocation() {
		Location location = new Location();
		location.setCity("test");
		location.setCountry("test");
		location.setLocationName("test");
		location.setState("test");
		location.setStreet("test");
		location.setZipcode("test");
		
		LocationService.create(location);
		
		Long id = location.getLocationId();
		
		return id;
	}
	
	@Test
	public void testReadLocation() {
		Long id = testCreateLocation();
		Location location = LocationService.read(id);
	}
	
	@Test
	public void testUpdateLocation() {
		Long id = testCreateLocation();
		Location location = LocationService.read(id);
		location.setLocationName("new name");
		
		LocationService.update(location);
	}
	
	@Test
	public void testDeleteLocation() {
		Long id = testCreateLocation();
		Location location = LocationService.read(id);

		LocationService.delete(location);
	}
}
