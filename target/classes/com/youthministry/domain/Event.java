package com.youthministry.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long eventId;
	private String eventName;
	private String eventDesc;
	private Date startTime;
	private Date endTime;
	@OneToOne(cascade=CascadeType.ALL)
	private Location location;
	/*@OneToMany
	@JoinTable(name="USER_VEHICLE", joinColumns=@JoinColumn(name="USER_ID"),
			   inverseJoinColumns=@JoinColumn(name="VEHICLE_ID")
			)*/
	//@OneToMany(mappedBy="user")
	@OneToMany(cascade=CascadeType.ALL)
	private Collection<Group> groups = new ArrayList<Group>();
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDesc() {
		return eventDesc;
	}
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Collection<Group> getGroups() {
		return groups;
	}
	public void setGroups(Collection<Group> groups) {
		this.groups = groups;
	}
	
}