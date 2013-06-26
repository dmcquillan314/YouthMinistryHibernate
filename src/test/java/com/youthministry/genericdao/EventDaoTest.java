package com.youthministry.genericdao;

import java.util.ArrayList;
import java.util.Date;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.youthministry.service.EventService;
import com.youthministry.domain.Event;
import com.youthministry.domain.Group;
import com.youthministry.domain.Location;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "root-context.xml"}) 
@TransactionConfiguration
@Transactional
public class EventDaoTest {
	@Autowired
	protected EventService EventService;

    final Logger logger = LoggerFactory.getLogger(EventDaoTest.class);
    
	public Long testCreateEvent() {
		Event event = new Event();
		event.setEventName("test case event name");
		event.setEventDesc("test case event description");
		Date startTime = new Date();
		Date endTime = new Date();
		event.setStartTime(startTime);
		event.setEndTime(endTime);
		
		Group group = new Group();
		Group group2 = new Group();
		group.setGroupName("test case group name");
		group2.setGroupName("test case group name 2");
		ArrayList<Group> groups = new ArrayList<Group>();
		groups.add(group);
		groups.add(group2);

		event.setGroups(groups);
		
		String city = "test city",
			   country = "test country",
			   locationName = "test location name",
			   state = "test state",
			   street = "test street",
			   zipcode = "test zipcode";
		
		Location location = new Location();
		location.setCity(city);
		location.setCountry(country);
		location.setLocationName(locationName);
		location.setState(state);
		location.setStreet(street);
		location.setZipcode(zipcode);
		
		event.setLocation(location);
		
		EventService.addEvent(event);
		
		return event.getEventId();
	}

	@Test
	public void testReadEvent() {
		Long id = testCreateEvent();
		Event event = EventService.getEventById(id);
		logger.info(event.toString());
	}
	
	@Test
	public void testUpdateEvent() {
		Long id = testCreateEvent();
		Event event = EventService.getEventById(id);
		event.setEventName("test event name updated");
		EventService.updateEvent(event);
	}
	
	@Test
	public void testDeleteEvent() {
		Long id = testCreateEvent();
		Event event = EventService.getEventById(id);
		EventService.deleteEvent(event);
		assertThat(null, is(EventService.getEventById(id)));
	}
}
